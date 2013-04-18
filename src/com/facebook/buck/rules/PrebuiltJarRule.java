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

package com.facebook.buck.rules;

import com.facebook.buck.model.AnnotationProcessingData;
import com.facebook.buck.model.BuildTarget;
import com.facebook.buck.model.BuildTargetPattern;
import com.facebook.buck.shell.Command;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * A rule that establishes a pre-compiled JAR file as a dependency.
 */
public class PrebuiltJarRule extends AbstractCachingBuildRule implements JavaLibraryRule {

  private final String binaryJar;
  @Nullable private final String sourceJar;
  @Nullable private final String javadocUrl;

  PrebuiltJarRule(BuildRuleParams buildRuleParams,
      String classesJar,
      String sourceJar,
      String javadocUrl) {
    super(buildRuleParams);
    this.binaryJar = Preconditions.checkNotNull(classesJar);
    this.sourceJar = sourceJar;
    this.javadocUrl = javadocUrl;
  }

  @Override
  public BuildRuleType getType() {
    return BuildRuleType.PREBUILT_JAR;
  }

  public String getBinaryJar() {
    return binaryJar;
  }

  public String getSourceJar() {
    return sourceJar;
  }

  public String getJavadocUrl() {
    return javadocUrl;
  }

  @Override
  protected Iterable<String> getInputsToCompareToOutput(BuildContext context) {
    return ImmutableList.of(getBinaryJar());
  }

  @Override
  public ImmutableSet<String> getClasspathEntries() {
    ImmutableSet.Builder<String> classpathEntries = ImmutableSet.builder();
    classpathEntries.add(getBinaryJar());
    classpathEntries.addAll(getClasspathEntriesForDeps());
    return classpathEntries.build();
  }

  @Override
  public ImmutableSortedSet<String> getJavaSrcs() {
    return ImmutableSortedSet.of();
  }

  @Override
  public AnnotationProcessingData getAnnotationProcessingData() {
    return AnnotationProcessingData.EMPTY;
  }

  @Override
  protected List<Command> buildInternal(BuildContext context)
      throws IOException {
    return ImmutableList.of();
  }

  @Override
  public File getOutput() {
    return new File(getBinaryJar());
  }

  @Override
  protected RuleKey.Builder ruleKeyBuilder() {
    return super.ruleKeyBuilder()
        .set("binaryJar", binaryJar)
        .set("sourceJar", sourceJar)
        .set("javadocUrl", javadocUrl);
  }

  public static Builder newPrebuiltJarRuleBuilder() {
    return new Builder();
  }

  public static class Builder extends AbstractBuildRuleBuilder {

    private String binaryJar;
    private String sourceJar;
    private String javadocUrl;

    private Builder() {}

    @Override
    public PrebuiltJarRule build(Map<String, BuildRule> buildRuleIndex) {
      return new PrebuiltJarRule(createBuildRuleParams(buildRuleIndex),
          binaryJar,
          sourceJar,
          javadocUrl);
    }

    @Override
    public Builder setBuildTarget(BuildTarget buildTarget) {
      super.setBuildTarget(buildTarget);
      return this;
    }

    @Override
    public Builder addDep(String dep) {
      super.addDep(dep);
      return this;
    }

    @Override
    public Builder addVisibilityPattern(BuildTargetPattern visibilityPattern) {
      super.addVisibilityPattern(visibilityPattern);
      return this;
    }

    public Builder setBinaryJar(String binaryJar) {
      this.binaryJar = binaryJar;
      return this;
    }

    public Builder setSourceJar(String sourceJar) {
      this.sourceJar = sourceJar;
      return this;
    }

    public Builder setJavadocUrl(String javadocUrl) {
      this.javadocUrl = javadocUrl;
      return this;
    }

  }
}
