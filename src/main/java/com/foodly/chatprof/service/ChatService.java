package com.foodly.chatprof.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder builder) {
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.builder().maxMessages(10).build();

        var options = OpenAiChatOptions.builder()
                .temperature(0.7)
                .frequencyPenalty(0.5)
                .build();

        this.chatClient = builder
                .defaultSystem(
                        """
                               Você é um assistente especializado em restaurantes e gastronomia da plataforma Foodly.
                               Responda de forma clara, simpática e útil.
                               Você pode ajudar com: recomendações de restaurantes, tipos de culinária, pratos populares,
                               dicas de pedidos, informações sobre ingredientes, restrições alimentares, e como funciona a plataforma Foodly.
                               Não fale sobre outros assuntos não relacionados a restaurantes, comida ou a plataforma Foodly.
                               Se não souber a resposta, diga que não sabe.
                               Use emojis e markdown para deixar as respostas mais agradáveis e organizadas.
                               Seja entusiasta sobre gastronomia e sempre incentive o usuário a experimentar novos pratos!
                        """
                ).defaultAdvisors(
                        new SimpleLoggerAdvisor(),
                        MessageChatMemoryAdvisor.builder(chatMemory).build()
                )
                .defaultOptions(options)
                .build();
    }

    public Flux<String> sendMessage(String message) {
        return chatClient.prompt()
                .user(message)
                .stream()
                .content();
    }

}
