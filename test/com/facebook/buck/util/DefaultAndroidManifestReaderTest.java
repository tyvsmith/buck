/*
 * Copyright 2012-present Facebook, Inc.
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

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class DefaultAndroidManifestReaderTest {

  @Test
  public void testReadPackage() throws IOException {
    AndroidManifestReader manifestReader = DefaultAndroidManifestReader.forString(String.format(
        "<manifest xmlns:android='http://schemas.android.com/apk/res/android' package='%s' />",
        "com.facebook.orca"));
    String packageName = manifestReader.getPackage();
    assertEquals("com.facebook.orca", packageName);
  }

  @Test
  public void testReadLauncherActivitiesNoneFound() throws IOException {
    AndroidManifestReader manifestReader = DefaultAndroidManifestReader.forString(
        "<manifest xmlns:android='http://schemas.android.com/apk/res/android'>" +
        "<application>" +
        "</application>" +
        "</manifest>");
    List<String> found = manifestReader.getLauncherActivities();
    List<String> expected = ImmutableList.of();
    assertEquals(expected, found);
  }

  @Test
  public void testReadLauncherActivities() throws IOException {
    AndroidManifestReader manifestReader = DefaultAndroidManifestReader.forString(
        "<manifest xmlns:android='http://schemas.android.com/apk/res/android'" +
        "          package='com.example'>" +
        "  <application>" +
        "    <activity android:name='com.example.Activity1'>" +
        "      <intent-filter>" +
        "        <action android:name='android.intent.action.MAIN' />" +
        "        <category android:name='android.intent.category.LAUNCHER' />" +
        "      </intent-filter>" +
        "    </activity>" +
        "    <activity android:name='.Activity2'>" +
        "        <activity/> <!-- Make sure a weird manifest doesn't ruin things! -->" +
        "      <intent-filter>" +
        "        <category android:name='android.intent.category.LAUNCHER' />" +
        "        <action android:name='android.intent.action.MAIN' />" +
        "      </intent-filter>" +
        "    </activity>" +
        "    <activity android:name='com.example.Activity3'>" +
        "      <intent-filter>" +
        "        <category android:name='android.intent.category.LAUNCHER' />" +
        "      </intent-filter>" +
        "    </activity>" +
        "    <activity android:name='com.example.Activity4'>" +
        "      <intent-filter>" +
        "        <action android:name='android.intent.action.MAIN' />" +
        "      </intent-filter>" +
        "    </activity>" +
        "  </application>" +
        "</manifest>");
    List<String> found = manifestReader.getLauncherActivities();
    List<String> expected = ImmutableList.of("com.example.Activity1", ".Activity2");
    assertEquals(expected, found);
  }
}
