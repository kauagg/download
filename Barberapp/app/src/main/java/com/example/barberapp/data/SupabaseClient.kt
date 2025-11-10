package com.example.barberapp.data

import io.github.jan-tennert.supabase.SupabaseClient
import io.github.jan-tennert.supabase.createSupabaseClient
import io.github.jan-tennert.supabase.gotrue.GoTrue
import io.github.jan-tennert.supabase.storage.Storage

object SupabaseConfig {
    const val SUPABASE_URL = "https://seu-projeto.supabase.co"
    const val SUPABASE_KEY = "sua-chave-publica"
    
    val client: SupabaseClient = createSupabaseClient(
        supabaseUrl = SUPABASE_URL,
        supabaseKey = SUPABASE_KEY
    ) {
        install(GoTrue)
        install(Storage)
    }
}