
package com.example.kosmajujaya

import androidx.compose.foundation.Canvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Blue = Color(0xFF1769E8)
private val DarkBlue = Color(0xFF12346B)
private val Background = Color(0xFFF5F8FF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme(
                colorScheme = lightColorScheme(
                    primary = Blue,
                    background = Background
                )
            ) {
                DashboardScreen()
            }
        }
    }
}

@Composable
fun DashboardScreen() {
    Scaffold(
        containerColor = Background,
        bottomBar = { BottomNavigation() }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            HeaderDashboard()

            WelcomeSection()

            Spacer(modifier = Modifier.height(12.dp))

            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    StatCard(
                        "🛏️", "6", "Total Kamar",
                        Color(0xFFE2ECFF), Modifier.weight(1f)
                    )
                    StatCard(
                        "🚪", "4", "Kamar Terisi",
                        Color(0xFFE0F5E9), Modifier.weight(1f)
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    StatCard(
                        "🏠", "2", "Kamar Kosong",
                        Color(0xFFFFEBDD), Modifier.weight(1f)
                    )
                    StatCard(
                        "👥", "4", "Jumlah Penghuni",
                        Color(0xFFECE5FF), Modifier.weight(1f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.Top
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(290.dp)
                ) {
                    FinanceSection()
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(290.dp)
                ) {
                    FinanceChartSection()
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            MenuSection()

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun HeaderDashboard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.horizontalGradient(
                    listOf(Blue, DarkBlue)
                )
            )
            .statusBarsPadding()
            .padding(horizontal = 18.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("🏠", fontSize = 34.sp)

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                "Manajemen Kos",
                color = Color.White,
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                "Kelola kos lebih mudah dan efisien",
                color = Color.White.copy(alpha = 0.9f),
                fontSize = 11.sp
            )
        }

        Text("🔔", fontSize = 24.sp)
    }
}

@Composable
fun WelcomeSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 14.dp)
            .background(Color.White, RoundedCornerShape(18.dp))
            .padding(horizontal = 18.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                "Selamat Datang,",
                fontSize = 15.sp,
                color = Color.Gray
            )

            Text(
                "Pemilik Kos!",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = DarkBlue
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "📅 Senin, 16 November 2026",
                fontSize = 11.sp,
                color = Color.Gray
            )
        }

        Text("🏘️", fontSize = 48.sp)
    }
}

@Composable
fun StatCard(
    icon: String,
    number: String,
    title: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.height(94.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = color
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(icon, fontSize = 27.sp)

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    number,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkBlue
                )

                Text(
                    title,
                    fontSize = 10.sp,
                    color = DarkBlue
                )
            }
        }
    }
}

@Composable
fun FinanceSection() {
    Card(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                "📊  Ringkasan Keuangan",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = DarkBlue
            )

            Spacer(modifier = Modifier.height(12.dp))

            FinanceItem(
                "Pemasukan",
                "Rp 3.500.000",
                Blue
            )

            Spacer(modifier = Modifier.height(8.dp))

            FinanceItem(
                "Pengeluaran",
                "Rp 750.000",
                Color(0xFFFF8A24)
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 10.dp),
                color = Color.LightGray
            )

            FinanceItem(
                "Selisih",
                "Rp 2.750.000",
                Color(0xFF15965B)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                "Data keuangan bulan ini",
                fontSize = 10.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun FinanceItem(
    title: String,
    amount: String,
    color: Color
) {
    Column {
        Text(
            title,
            color = Color.Gray,
            fontSize = 12.sp
        )

        Text(
            amount,
            color = color,
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun MenuSection() {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Menu Utama",
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = DarkBlue,
                modifier = Modifier.weight(1f)
            )

            Text(
                "Lihat Semua",
                color = Blue,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        val menus = listOf(
            "🛏️" to "Manajemen\nKamar",
            "👥" to "Manajemen\nPenghuni",
            "💳" to "Pembayaran\nSewa",
            "🧾" to "Pengeluaran\nOperasional",
            "📈" to "Laporan\nKeuangan",
            "🔍" to "Pencarian\nData"
        )

        menus.chunked(3).forEach { rowMenus ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                rowMenus.forEach { menu ->
                    MenuCard(
                        icon = menu.first,
                        title = menu.second,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun MenuCard(
    icon: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(100.dp)
            .clickable { },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(icon, fontSize = 27.sp)

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                title,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                color = DarkBlue,
                lineHeight = 15.sp
            )
        }
    }
}

@Composable
fun BottomNavigation() {
    NavigationBar(
        containerColor = Color.White
    ) {
        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = { Text("⌂", fontSize = 25.sp) },
            label = { Text("Dashboard") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Text("▥", fontSize = 23.sp) },
            label = { Text("Riwayat") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Text("⚙", fontSize = 23.sp) },
            label = { Text("Pengaturan") }
        )
        }

    }

@Composable
fun FinanceChartSection() {
    val months = listOf("Jun", "Jul", "Agu", "Sep", "Okt", "Nov")

    val incomes = listOf(3.2f, 3.5f, 3.8f, 3.4f, 4.1f, 3.5f)
    val expenses = listOf(0.8f, 1.1f, 0.9f, 1.2f, 1.0f, 0.75f)

    val incomeColor = Color(0xFF2878E8)
    val expenseColor = Color(0xFFF59A38)

    Card(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                "Grafik Keuangan",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = DarkBlue
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                "Perbandingan pemasukan dan pengeluaran",
                fontSize = 11.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(
                                incomeColor,
                                RoundedCornerShape(3.dp)
                            )
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Pemasukan", fontSize = 11.sp, color = Color.Gray)
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(
                                expenseColor,
                                RoundedCornerShape(3.dp)
                            )
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Pengeluaran", fontSize = 11.sp, color = Color.Gray)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(205.dp)
            ) {
                val canvas = drawContext.canvas.nativeCanvas

                val paint = Paint(Paint.ANTI_ALIAS_FLAG)

                val density = density

                val left = 42.dp.toPx()
                val right = size.width - 8.dp.toPx()
                val top = 12.dp.toPx()
                val bottom = size.height - 30.dp.toPx()

                val chartHeight = bottom - top
                val chartWidth = right - left
                val maxValue = 5f

                // Garis dan angka sumbu Y
                for (i in 0..5) {
                    val value = i.toFloat()
                    val y = bottom - (value / maxValue) * chartHeight

                    paint.color = android.graphics.Color.LTGRAY
                    paint.strokeWidth = 1.dp.toPx()
                    paint.style = Paint.Style.STROKE

                    canvas.drawLine(
                        left,
                        y,
                        right,
                        y,
                        paint
                    )

                    paint.style = Paint.Style.FILL
                    paint.color = android.graphics.Color.GRAY
                    paint.textSize = 10.sp.toPx()
                    paint.textAlign = Paint.Align.RIGHT

                    canvas.drawText(
                        value.toInt().toString(),
                        left - 8.dp.toPx(),
                        y + 4.dp.toPx(),
                        paint
                    )
                }

                // Grafik batang
                val groupWidth = chartWidth / months.size
                val barWidth = 10.dp.toPx()
                val barGap = 4.dp.toPx()

                for (i in months.indices) {
                    val centerX = left + groupWidth * (i + 0.5f)

                    val incomeHeight =
                        (incomes[i] / maxValue) * chartHeight

                    val expenseHeight =
                        (expenses[i] / maxValue) * chartHeight

                    // Batang pemasukan
                    paint.color = incomeColor.toArgb()
                    paint.style = Paint.Style.FILL

                    canvas.drawRoundRect(
                        centerX - barWidth - barGap / 2,
                        bottom - incomeHeight,
                        centerX - barGap / 2,
                        bottom,
                        5.dp.toPx(),
                        5.dp.toPx(),
                        paint
                    )

                    // Batang pengeluaran
                    paint.color = expenseColor.toArgb()

                    canvas.drawRoundRect(
                        centerX + barGap / 2,
                        bottom - expenseHeight,
                        centerX + barWidth + barGap / 2,
                        bottom,
                        5.dp.toPx(),
                        5.dp.toPx(),
                        paint
                    )

                    // Nama bulan
                    paint.color = android.graphics.Color.GRAY
                    paint.textSize = 10.sp.toPx()
                    paint.textAlign = Paint.Align.CENTER

                    canvas.drawText(
                        months[i],
                        centerX,
                        size.height - 6.dp.toPx(),
                        paint
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Nilai dalam jutaan rupiah",
                fontSize = 10.sp,
                color = Color.Gray
            )
        }
    }
}