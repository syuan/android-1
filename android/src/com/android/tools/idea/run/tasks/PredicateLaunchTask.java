/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.tools.idea.run.tasks;

import com.android.ddmlib.IDevice;
import com.android.tools.idea.run.ConsolePrinter;
import com.android.tools.idea.run.util.LaunchStatus;
import org.jetbrains.annotations.NotNull;

public class PredicateLaunchTask implements LaunchTask {
  public interface Predicate {
    boolean isSuccess();
  }

  private final LaunchTask myTask;
  private final Predicate myPredicate;

  public PredicateLaunchTask(@NotNull LaunchTask task, @NotNull Predicate predicate) {
    myTask = task;
    myPredicate = predicate;
  }

  @NotNull
  @Override
  public String getDescription() {
    return myTask.getDescription();
  }

  @Override
  public int getDuration() {
    return myTask.getDuration();
  }

  @Override
  public boolean perform(@NotNull IDevice device, @NotNull LaunchStatus launchStatus, @NotNull ConsolePrinter printer) {
    if (myPredicate.isSuccess()) {
      myTask.perform(device, launchStatus, printer);
    }

    return true;
  }
}
