package com.foodly.chatprof.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.foodly.chatprof.service.ChatService;

import java.time.Instant;

@Route
public class HomeView extends VerticalLayout {

    private final ChatService chatService;
    private final MessageList list = new MessageList();

    public HomeView(ChatService chatService) {
        this.chatService = chatService;

        add(new H1("🍽️ Foodly AI - Assistente de Restaurantes"));
        add(new Paragraph("Tire suas dúvidas sobre restaurantes, pratos e a plataforma Foodly!"));

        MessageInput input = new MessageInput();
        input.addSubmitListener(submitEvent -> {
            String messageText = submitEvent.getValue();
            addMessage(messageText, "Você");

            var responseMessage = new MessageListItem("", Instant.now(), "Foodly AI 🤖");
            list.addItem(responseMessage);

            chatService.sendMessage(messageText).subscribe(partialResponse -> {
                getUI().ifPresent(ui -> ui.access(() -> {
                    responseMessage.appendText(partialResponse);
                }));
            });
        });

        input.setWidthFull();
        list.setHeightFull();
        list.setWidthFull();
        list.setMarkdown(true);
        setHeightFull();

        add(list);
        add(input);
    }

    private void addMessage(String messageText, String userName) {
        var message = new MessageListItem(messageText, Instant.now(), userName);
        message.setUserColorIndex(1);
        list.addItem(message);
    }
}
