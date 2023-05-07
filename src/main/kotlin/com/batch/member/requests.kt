package com.batch.member

class CreateMemberDto(
    val memberId: Long,
    val password: String,
    val email: String,
    val role: com.batch.member.ROLE,
)

class LoginDto(
    val memberId: String,
    val password: String,
)
