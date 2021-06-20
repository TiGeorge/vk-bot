package com.example.vkbot.config;

import com.example.vkbot.handlers.CallbackHandler;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class CallbackHandlerStartupRunner implements ApplicationListener<ContextRefreshedEvent> {

  private final CallbackHandler callbackHandler;

  @Value("${app.autorunHandler}")
  private boolean autorunHandler;

  @SneakyThrows
  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    if (autorunHandler) {
      log.info("CallbackHandler run");
      callbackHandler.run();
    }
  }
}
