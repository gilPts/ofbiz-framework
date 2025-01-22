/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.ofbiz.security;

import java.util.regex.Pattern;
import org.apache.ofbiz.base.util.UtilCodec;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SecurityUtilTest {

    @Test
    public void basicAdminPermissionTesting() {
        List<String> adminPermissions = Arrays.asList("PARTYMGR", "EXAMPLE", "ACCTG_PREF");
        assertTrue(SecurityUtil.checkMultiLevelAdminPermissionValidity(adminPermissions, "PARTYMGR_CREATE"));
        assertTrue(SecurityUtil.checkMultiLevelAdminPermissionValidity(adminPermissions, "EXAMPLE_CREATE "));
        assertTrue(SecurityUtil.checkMultiLevelAdminPermissionValidity(adminPermissions, "EXAMPLE_ADMIN"));
        assertFalse(SecurityUtil.checkMultiLevelAdminPermissionValidity(adminPermissions, "ACCTG_ADMIN"));
    }

    @Test
    public void multiLevelAdminPermissionTesting() {
        List<String> adminPermissions = Arrays.asList("PARTYMGR", "EXAMPLE", "ACCTG_PREF");
        assertTrue(SecurityUtil.checkMultiLevelAdminPermissionValidity(adminPermissions, "PARTYMGR_CME_CREATE"));
        assertTrue(SecurityUtil.checkMultiLevelAdminPermissionValidity(
                    adminPermissions, "EXAMPLE_WITH_MULTI_LEVEL_ADMIN"));
        assertFalse(SecurityUtil.checkMultiLevelAdminPermissionValidity(adminPermissions, "ACCTG_ADMIN"));
    }

    @Test
    public void multiLevelBadHierarchyPermissionTesting() {
        List<String> adminPermissions = Arrays.asList("PARTYMGR", "EXAMPLE", "ACCTG_PREF");
        assertFalse(SecurityUtil.checkMultiLevelAdminPermissionValidity(
                    adminPermissions, "SPECIFIC_MULTI_LEVEL_EXAMPLE_VIEW"));
        assertFalse(SecurityUtil.checkMultiLevelAdminPermissionValidity(adminPermissions, "HOTDEP_PARTYMGR_ADMIN"));
    }

    @Test
    public void isDeniedWebShell() {
        Pattern testDeniedWebShellTokens = SecuredUpload.computeDeniedWebShellTokensPattern(List.of("suspecttoken", "allowedtoken"));
        List.of(" suspecttoken.",
                        " suspectToken.",
                        " SuspectToken.",
                        " SUSPECTTOKEN.",
                        " suspectToken.",
                        "<suspectToken ",
                        "<suspectToken:",
                        "< suspectToken :",
                        "<%@ suspectToken ",
                        "<?suspectToken ",
                        " suspectToken(",
                        "%suspectToken,",
                        "/suspectToken*",
                        "\"suspectToken\"",
                        "*suspectToken|",
                        "+suspectToken|",
                        "=suspectToken|",
                        "|suspectToken ")
                .forEach(token -> {
                    String encodedToken = UtilCodec.getEncoder("url").encode(token);
                    assertTrue("failed to stop '" + token + "' encoded as '" + encodedToken + " with " + testDeniedWebShellTokens,
                            SecuredUpload.containsDeniedWebShellToken(List.of(encodedToken), List.of(), testDeniedWebShellTokens));
                });
    }

    @Test
    public void isAllowedWebShell() {
        Pattern testDeniedWebShellTokens = SecuredUpload.computeDeniedWebShellTokensPattern(List.of("suspecttoken", "allowedtoken"));
        List.of(" suspecttokena ",
                        "suspectToken",
                        " allowedToken(",
                        " allowedtoken(")
                .forEach(token -> {
                    String encodedToken = UtilCodec.getEncoder("url").encode(token);
                    assertFalse("failed to allow '" + token + "' encoded as '" + encodedToken + " with " + testDeniedWebShellTokens,
                            SecuredUpload.containsDeniedWebShellToken(List.of(encodedToken), List.of("allowedtoken"), testDeniedWebShellTokens));
                });
    }
}
