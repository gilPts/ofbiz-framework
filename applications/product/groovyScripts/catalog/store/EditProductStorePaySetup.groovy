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

import org.apache.ofbiz.entity.condition.EntityCondition
import org.apache.ofbiz.entity.condition.EntityOperator

paymentMethodTypeId = request.getParameter('paymentMethodTypeId')
paymentServiceTypeEnumId = request.getParameter('paymentServiceTypeEnumId')
customMethodsCond = null

if (paymentMethodTypeId && paymentServiceTypeEnumId) {
    if ('CREDIT_CARD' == paymentMethodTypeId && 'PRDS_PAY_AUTH' == paymentServiceTypeEnumId ) {
        customMethodsCond = EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'CC_AUTH')
    } else if ('CREDIT_CARD' == paymentMethodTypeId && 'PRDS_PAY_CAPTURE' == paymentServiceTypeEnumId ) {
        customMethodsCond = EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'CC_CAPTURE')
    } else if ('CREDIT_CARD' == paymentMethodTypeId && 'PRDS_PAY_REAUTH' == paymentServiceTypeEnumId ) {
        customMethodsCond = EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'CC_AUTH')
    } else if ('CREDIT_CARD' == paymentMethodTypeId && 'PRDS_PAY_REFUND' == paymentServiceTypeEnumId ) {
        customMethodsCond = EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'CC_REFUND')
    } else if ('CREDIT_CARD' == paymentMethodTypeId && 'PRDS_PAY_RELEASE' == paymentServiceTypeEnumId ) {
        customMethodsCond = EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'CC_RELEASE')
    } else if ('EFT_ACCOUNT' == paymentMethodTypeId && 'PRDS_PAY_AUTH' == paymentServiceTypeEnumId ) {
        customMethodsCond = EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'EFT_AUTH')
    } else if ('EFT_ACCOUNT' == paymentMethodTypeId && 'PRDS_PAY_RELEASE' == paymentServiceTypeEnumId ) {
        customMethodsCond = EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'EFT_RELEASE')
    } else if ('FIN_ACCOUNT' == paymentMethodTypeId && 'PRDS_PAY_AUTH' == paymentServiceTypeEnumId ) {
        customMethodsCond = EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'FIN_AUTH')
    } else if ('FIN_ACCOUNT' == paymentMethodTypeId && 'PRDS_PAY_CAPTURE' == paymentServiceTypeEnumId ) {
        customMethodsCond = EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'FIN_CAPTURE')
    } else if ('FIN_ACCOUNT' == paymentMethodTypeId && 'PRDS_PAY_REFUND' == paymentServiceTypeEnumId ) {
        customMethodsCond = EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'FIN_REFUND')
    } else if ('FIN_ACCOUNT' == paymentMethodTypeId && 'PRDS_PAY_RELEASE' == paymentServiceTypeEnumId ) {
        customMethodsCond = EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'FIN_RELEASE')
    } else if ('GIFT_CARD' == paymentMethodTypeId && 'PRDS_PAY_AUTH' == paymentServiceTypeEnumId ) {
        customMethodsCond = EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'GIFT_AUTH')
    } else if ('GIFT_CARD' == paymentMethodTypeId && 'PRDS_PAY_CAPTURE' == paymentServiceTypeEnumId ) {
        customMethodsCond = EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'GIFT_CAPTURE')
    } else if ('GIFT_CARD' == paymentMethodTypeId && 'PRDS_PAY_REFUND' == paymentServiceTypeEnumId ) {
        customMethodsCond = EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'GIFT_REFUND')
    } else if ('GIFT_CARD' == paymentMethodTypeId && 'PRDS_PAY_RELEASE' == paymentServiceTypeEnumId ) {
        customMethodsCond = EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'GIFT_RELEASE')
    }
}

if (!paymentMethodTypeId || !paymentServiceTypeEnumId) {
    List customMethods = [
            EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'CC_AUTH'),
            EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'CC_CAPTURE'),
            EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'CC_REAUTH'),
            EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'CC_REFUND'),
            EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'CC_RELEASE'),
            EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'CC_CREDIT'),
            EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'EFT_AUTH'),
            EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'EFT_RELEASE'),
            EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'FIN_AUTH'),
            EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'FIN_CAPTURE'),
            EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'FIN_REFUND'),
            EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'FIN_RELEASE'),
            EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'GIFT_AUTH'),
            EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'GIFT_CAPTURE'),
            EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'GIFT_REFUND'),
            EntityCondition.makeCondition('customMethodTypeId', EntityOperator.EQUALS, 'GIFT_RELEASE')
    ]
    customMethodsCond = EntityCondition.makeCondition(customMethods, EntityOperator.OR)
}
if ('PRDS_PAY_EXTERNAL' == paymentServiceTypeEnumId) {
    context.paymentCustomMethods = null
} else if (customMethodsCond) {
    context.paymentCustomMethods = from('CustomMethod').where(customMethodsCond).orderBy('description').queryList()
} else {
    context.paymentCustomMethods = from('CustomMethod').orderBy('description').queryList()
}
