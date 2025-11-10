package com.example.barberapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    val barbers = listOf(
        Barber("1", "João Silva", "Corte Social", 4.8, "", "Especialista em cortes modernos"),
        Barber("2", "Pedro Santos", "Barba", 4.9, "", "Mestre em barbas"),
        Barber("3", "Carlos Lima", "Degradê", 4.7, "", "Rei do degradê")
    )
    
    val services = listOf(
        Service("1", "Corte Social", 30, 25.0, "Corte tradicional"),
        Service("2", "Barba", 20, 15.0, "Aparar e modelar"),
        Service("3", "Corte + Barba", 45, 35.0, "Combo completo")
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Barbearia Style") },
                actions = {
                    IconButton(onClick = { navController.navigate("profile") }) {
                        Icon(Icons.Default.Person, contentDescription = "Perfil")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("schedule") }
            ) {
                Icon(Icons.Default.Schedule, contentDescription = "Agendar")
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            item {
                Text(
                    "Nossos Barbeiros",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            
            items(barbers) { barber ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    onClick = { /* Detalhes do barbeiro */ }
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Avatar do barbeiro
                        Surface(
                            modifier = Modifier.size(50.dp),
                            shape = MaterialTheme.shapes.medium,
                            color = MaterialTheme.colorScheme.primaryContainer
                        ) {
                            Box(
                                contentAlignment = Alignment.Center
                            ) {
                                Text(barber.name.take(1))
                            }
                        }
                        
                        Spacer(modifier = Modifier.width(16.dp))
                        
                        Column {
                            Text(
                                barber.name,
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                barber.specialty,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                "⭐ ${barber.rating}",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
            
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    "Serviços",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            
            items(services) { service ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(service.name)
                            Text(
                                service.description,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        
                        Column(horizontalAlignment = Alignment.End) {
                            Text(
                                "R$ ${service.price}",
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                "${service.duration} min",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }
    }
}