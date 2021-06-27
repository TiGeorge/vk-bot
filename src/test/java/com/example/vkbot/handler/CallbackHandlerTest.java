package com.example.vkbot.handler;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

import com.example.vkbot.service.KeyboardService;
import com.vk.api.sdk.actions.Messages;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.queries.messages.MessagesSendQueryWithUserIds;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CallbackHandlerTest {

  @Mock private VkApiClient client;
  @Mock private GroupActor actor;
  @Mock private Messages messages;
  @Mock private KeyboardService keyboardService;
  @Mock private MessagesSendQueryWithUserIds messagesSendQueryWithUserIds;
  @Captor private ArgumentCaptor<String> stringCaptor;

  @Test
  void messageNew() {
    // Arrange
    when(client.messages()).thenReturn(messages);
    when(messages.sendWithUserIds(isA(GroupActor.class), isA(Integer[].class)))
        .thenReturn(messagesSendQueryWithUserIds);
    when(messagesSendQueryWithUserIds.message(isA(String.class)))
        .thenReturn(messagesSendQueryWithUserIds);
    when(messagesSendQueryWithUserIds.randomId(isA(Integer.class)))
        .thenReturn(messagesSendQueryWithUserIds);

    Message message = new Message();
    message.setFromId(111);
    message.setText("Some text");

    CallbackHandler sut = new CallbackHandler(client, actor, keyboardService);

    // Act
    sut.messageNew(777, message);

    // Assert
    verify(messagesSendQueryWithUserIds, times(1)).message(stringCaptor.capture());
    assertThat(stringCaptor.getValue()).isEqualTo("Some text");
  }
}
