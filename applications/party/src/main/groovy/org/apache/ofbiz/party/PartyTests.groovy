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
package org.apache.ofbiz.party

import org.apache.ofbiz.entity.GenericValue
import org.apache.ofbiz.service.ServiceUtil
import org.apache.ofbiz.service.testtools.OFBizTestCase

class PartyTests extends OFBizTestCase {
    public PartyTests(String name) {
        super(name)
    }

    void testCreatePartyPostalAddress() {
        Map serviceCtx = [
                contactMechId: 'TestPostalAddress',
                partyId: 'TestCustomer',
                toName: 'Test Address',
                address1: '2004 Factory Blvd',
                city: 'City of Industry',
                countryGeoId: 'USA',
                stateProvinceGeoId: 'CA',
                postalCode: '90000',
                userLogin: userLogin
        ]
        Map serviceResult = dispatcher.runSync('createPartyPostalAddress', serviceCtx)
        assert ServiceUtil.isSuccess(serviceResult)

        GenericValue postalAddress = from('PostalAddress').where('contactMechId', serviceResult.contactMechId).queryOne()
        assert postalAddress != null
        postalAddress.city = 'City of Industry'
    }
}