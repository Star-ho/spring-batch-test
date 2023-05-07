package com.sungho.member

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, Long> {
    @Query("Select id, PASSWORD,EMAIL,ROLE from MEMBER LIMIT :page, :limitNum", nativeQuery = true)
    fun findAllByCondition(page: Int, limitNum: Int): List<Member>
}