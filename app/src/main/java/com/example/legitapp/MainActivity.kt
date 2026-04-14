package com.example.legitapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.legitapp.ui.theme.LegitAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LegitAppTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(32.dp)
                    ) {
                        Text(text = "🎓", fontSize = 64.sp)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "UPB Notes",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Share your notes with colleagues",
                            fontSize = 14.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(48.dp))

                        Button(
                            onClick = {
                                val intent = Intent(Intent.ACTION_SEND).apply {
                                    type = "text/plain"
                                    putExtra(
                                        Intent.EXTRA_TEXT,
                                        "notes: Curs SO laborator 3..."
                                    )
                                }
                                startActivity(Intent.createChooser(intent, "Share via"))
                            },
                            modifier = Modifier.fillMaxWidth().height(52.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF998A))
                        ) {
                            Text(text = "📤 Share Notes", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                        }

                        Spacer(modifier = Modifier.height(12.dp))


                        Button(
                            onClick = {
                                val intent = Intent(Intent.ACTION_SEND).apply {
                                    type = "text/plain"
                                    putExtra(
                                        Intent.EXTRA_TEXT,
                                        "notes: Curs SO laborator 3..."
                                    )
                                    setPackage("com.google.android.gm")
                                }
                                startActivity(intent)
                            },
                            modifier = Modifier.fillMaxWidth().height(52.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF43A047))
                        ) {
                            Text(text = "📤 Share Notes (Safe)", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                        }

                        Spacer(modifier = Modifier.height(16.dp))
//                        Text(
//                            text = "Red = implicit intent\nGreen = explicit intent",
//                            fontSize = 12.sp,
//                            color = Color.Gray,
//                            textAlign = TextAlign.Center
//                        )
                    }
                }
            }
        }
    }
}