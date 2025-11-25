package io.hivebit.companion.android.database.widget.converters

import androidx.room.TypeConverter
import io.hivebit.companion.android.common.util.kotlinJsonMapper
import io.hivebit.companion.android.database.widget.TodoWidgetEntity

class TodoLastUpdateDataConverter {
    @TypeConverter
    fun fromJson(value: String?): TodoWidgetEntity.LastUpdateData? {
        return value?.let { kotlinJsonMapper.decodeFromString<TodoWidgetEntity.LastUpdateData>(it) }
    }

    @TypeConverter
    fun toJson(data: TodoWidgetEntity.LastUpdateData?): String? {
        return data?.let { kotlinJsonMapper.encodeToString(it) }
    }
}
