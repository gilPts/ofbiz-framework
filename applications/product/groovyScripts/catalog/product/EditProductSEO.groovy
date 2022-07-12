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

productId = parameters.productId
if (productId) {
    productContents  = from('ProductContent').where('productId', productId).queryList()
    productContents.each{ productContent->
        if ('PAGE_TITLE' == productContent.productContentTypeId) {
            contentTitle  = from('Content').where('contentId', productContent.contentId).queryOne()
            dataTextTitle  = from('ElectronicText').where('dataResourceId', contentTitle.dataResourceId).queryOne()
            context.title = dataTextTitle.textData
        }
        if ('META_KEYWORD' == productContent.productContentTypeId) {
            contentMetaKeyword  = from('Content').where('contentId', productContent.contentId).queryOne()
            dataTextMetaKeyword  = from('ElectronicText').where('dataResourceId', contentMetaKeyword.dataResourceId).queryOne()
            context.metaKeyword = dataTextMetaKeyword.textData
        }
        if ('META_DESCRIPTION' == productContent.productContentTypeId) {
            contentMetaDescription  = from('Content').where('contentId', productContent.contentId).queryOne()
            dataTextMetaDescription  = from('ElectronicText').where('dataResourceId', contentMetaDescription.dataResourceId).queryOne()
            context.metaDescription = dataTextMetaDescription.textData
        }
    }
}
