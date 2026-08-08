package io.lunosfer.dreamap.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.ElectricBolt
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.lunosfer.dreamap.ui.theme.*

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Void950)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text = "HOŞ GELDİN",
                color = AstralGold.copy(alpha = 0.8f),
                style = MaterialTheme.typography.labelLarge.copy(
                    letterSpacing = 2.sp,
                    fontFamily = SansFontFamily
                )
            )
            Text(
                text = "Astral Gezgin",
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontFamily = SerifFontFamily,
                    fontWeight = FontWeight.Light
                )
            )
        }

        // Active Vision Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Void800.copy(alpha = 0.6f)),
            border = BorderStroke(1.dp, Color.White.copy(alpha = 0.05f))
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                // Background glow simulation
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = 16.dp, y = (-16).dp)
                        .size(128.dp)
                        .background(AetherViolet.copy(alpha = 0.1f), CircleShape)
                )

                Column(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text(
                            text = "Aktif Vizyonun Yok",
                            color = AstralGold,
                            style = MaterialTheme.typography.titleLarge.copy(fontFamily = SerifFontFamily)
                        )
                        Text(
                            text = "Henüz bir vizyon belirlemedin. Geleceğini şekillendirmek için yeni bir vizyon eklemeye ne dersin?",
                            color = Color(0xFF94A3B8), // slate-400
                            style = MaterialTheme.typography.bodyMedium.copy(lineHeight = 20.sp)
                        )
                    }

                    OutlinedButton(
                        onClick = { /* TODO */ },
                        modifier = Modifier.fillMaxWidth().height(48.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = AstralGold),
                        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.1f))
                    ) {
                        Text("Vizyon Belirle", fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }

        // Stats Grid
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Dream Record
            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Void800.copy(alpha = 0.6f)),
                border = BorderStroke(1.dp, Color.White.copy(alpha = 0.05f))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(AetherIndigo.copy(alpha = 0.1f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Filled.Book, contentDescription = null, tint = AetherIndigo, modifier = Modifier.size(20.dp))
                    }
                    Text("Rüya Kaydı", color = Color(0xFF94A3B8), fontSize = 12.sp)
                    Text("12", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
            }

            // Aura Power
            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Void800.copy(alpha = 0.6f)),
                border = BorderStroke(1.dp, Color.White.copy(alpha = 0.05f))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(AstralAmber.copy(alpha = 0.1f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Filled.ElectricBolt, contentDescription = null, tint = AstralAmber, modifier = Modifier.size(20.dp))
                    }
                    Text("Aura Gücü", color = Color(0xFF94A3B8), fontSize = 12.sp)
                    Text("Low", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        // Explore Header
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Keşfet",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge.copy(fontFamily = SerifFontFamily)
            )
            Text(
                text = "TÜMÜNÜ GÖR",
                color = AstralGold,
                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold, letterSpacing = 2.sp)
            )
        }
    }
}
