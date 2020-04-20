/*
 * Copyright 2020 Nicolas Maltais
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.maltaisn.notes.model.converter

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals


class DateTimeConverterTest {

    private val json = Json(JsonConfiguration.Stable)

    @Test
    fun `should convert date to string`() {
        assertEquals("2020-04-18T17:14:31.650Z",
                DateTimeConverter.toString(Date(1587230071650)))
    }

    @Test
    fun `should convert string to date`() {
        assertEquals(Date(1587230071650),
                DateTimeConverter.toDate("2020-04-18T17:14:31.650Z"))
    }

    @Test
    fun `should convert date to json literal`() {
        assertEquals("\"2020-04-18T17:14:31.650Z\"",
                json.stringify(DateTimeConverter, Date(1587230071650)))
    }

    @Test
    fun `should convert json literal to date`() {
        assertEquals(Date(1587230071650),
                json.parse(DateTimeConverter, "\"2020-04-18T17:14:31.650Z\""))
    }

}