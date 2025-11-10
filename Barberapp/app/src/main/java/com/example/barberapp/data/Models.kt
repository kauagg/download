package com.example.barberapp.data

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class UserProfile(
    val id: String = "",
    val email: String = "",
    val fullName: String = "",
    val phone: String = "",
    val avatarUrl: String = "",
    val createdAt: String = ""
)

@Serializable
data class Barber(
    val id: String = "",
    val name: String = "",
    val specialty: String = "",
    val rating: Double = 0.0,
    val photoUrl: String = "",
    val description: String = ""
)

@Serializable
data class Service(
    val id: String = "",
    val name: String = "",
    val duration: Int = 0,
    val price: Double = 0.0,
    val description: String = ""
)

@Serializable
data class Appointment(
    val id: String = "",
    val userId: String = "",
    val barberId: String = "",
    val serviceId: String = "",
    val dateTime: String = "",
    val status: String = "pending",
    val notes: String = ""
)