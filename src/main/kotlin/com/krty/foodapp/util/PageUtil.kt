package com.krty.foodapp.util

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import java.nio.ByteBuffer
import java.util.Base64

object PageUtil {
    fun fromCursor(cursor: String): Pageable {
        val bb = ByteBuffer.wrap(Base64.getDecoder().decode(cursor))
        return PageRequest.of(
            bb.int,
            bb.int
        )
    }

    fun firstPage(size: Int) = PageRequest.of(
        0, size
    )

    fun toCursor(page: Pageable): String {
        val bb = ByteBuffer.allocate(Int.SIZE_BYTES * 2)
        bb.putInt(page.pageNumber)
        bb.putInt(page.pageSize)
        return Base64.getEncoder().encodeToString(bb.array())
    }
}