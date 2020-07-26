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

import androidx.room.TypeConverter
import com.maltaisn.notes.model.entity.PinnedStatus
import kotlinx.serialization.*


@Serializer(forClass = PinnedStatus::class)
object PinnedStatusConverter : KSerializer<PinnedStatus> {

    @TypeConverter
    @JvmStatic
    fun toInt(status: PinnedStatus) = status.value

    @TypeConverter
    @JvmStatic
    fun toStatus(value: Int) = PinnedStatus.values().find { it.value == value }
            ?: error("Unknown pinned status value")

    override val descriptor = PrimitiveDescriptor("PinnedStatus", PrimitiveKind.INT)
    override fun serialize(encoder: Encoder, value: PinnedStatus) = encoder.encodeInt(toInt(value))
    override fun deserialize(decoder: Decoder) = toStatus(decoder.decodeInt())

}
