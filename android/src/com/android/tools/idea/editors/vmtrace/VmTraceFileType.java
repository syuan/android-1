/*
 * Copyright (C) 2015 The Android Open Source Project
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
package com.android.tools.idea.editors.vmtrace;

import com.android.ddmlib.DdmConstants;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.vfs.VirtualFile;
import icons.AndroidIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class VmTraceFileType implements FileType {
  public static final VmTraceFileType INSTANCE = new VmTraceFileType();

  @NotNull
  @Override
  public String getName() {
    return "VmTrace";
  }

  @NotNull
  @Override
  public String getDescription() {
    return "Method tracing file";
  }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return DdmConstants.EXTENSION;
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return AndroidIcons.Ddms.StartMethodProfiling;
  }

  @Override
  public boolean isBinary() {
    return true;
  }

  @Override
  public boolean isReadOnly() {
    return true;
  }

  @Nullable
  @Override
  public String getCharset(@NotNull VirtualFile file, @NotNull byte[] content) {
    return null;
  }
}
