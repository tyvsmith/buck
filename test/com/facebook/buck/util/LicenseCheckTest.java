/*
 * Copyright 2013-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.facebook.buck.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class LicenseCheckTest {

  @Test
  public void ensureAllSrcFilesHaveTheApacheLicense() {
    new JavaCopyrightTraversal(new File("src")).traverse();
    new JavaCopyrightTraversal(new File("test")).traverse();
  }

  private static class JavaCopyrightTraversal extends DirectoryTraversal {
    private static Pattern LICENSE_FRAGMENT = Pattern.compile(
        // TODO(simons): This is very lame.
        // The newline character doesn't match "\w", "\\n" so do a non-greedy match until the next
        // part of the copyright.
        "^/\\\\*.*?" +
        "\\\\* Copyright 20\\d\\d-present Facebook, Inc\\..*?" +
        "\\\\* Licensed under the Apache License, Version 2.0 \\(the \"License\"\\); you may.*",
        Pattern.MULTILINE | Pattern.DOTALL);

    public JavaCopyrightTraversal(File root) {
      super(root);
    }

    @Override
    public void visit(File file, String relativePath) {
      if (!"java".equals(Files.getFileExtension(relativePath))) {
        return;
      }

      try {
        String asString = Files.toString(file, Charsets.UTF_8);

        assertTrue("Check license of: " + relativePath,
            LICENSE_FRAGMENT.matcher(asString).matches());
      } catch (IOException e) {
        fail("Unable to read: " + relativePath);
      }
    }
  }
}
