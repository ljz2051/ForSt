/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.rocksdb.flink;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.rocksdb.EnvFlinkTestSuite;
import org.rocksdb.RocksNativeLibraryResource;

/**
 * Unit test for env/flink/env_flink.cc.
 */
public class FlinkEnvTest {
  @ClassRule
  public static final RocksNativeLibraryResource ROCKS_NATIVE_LIBRARY_RESOURCE =
      new RocksNativeLibraryResource();

  @Rule public TemporaryFolder parentFolder = new TemporaryFolder();

  @Test
  public void runEnvFlinkTestSuites() throws Exception {
    String basePath = parentFolder.newFolder().toURI().toString();
    try (EnvFlinkTestSuite testSuite = new EnvFlinkTestSuite(basePath)) {
      testSuite.runAllTestSuites();
    }
  }
}