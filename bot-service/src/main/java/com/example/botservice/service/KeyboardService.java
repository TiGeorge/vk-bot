package com.example.botservice.service;

import com.vk.api.sdk.objects.messages.Keyboard;
import java.util.concurrent.ExecutionException;

public interface KeyboardService {

  Keyboard findKeyboardById(long longValue) throws ExecutionException, InterruptedException;

  Keyboard findKeyboardForCommunity(int i) throws ExecutionException, InterruptedException;
}
