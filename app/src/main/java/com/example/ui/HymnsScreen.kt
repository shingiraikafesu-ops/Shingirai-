package com.example.ui

import android.app.Activity
import android.view.WindowManager
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.R
import com.example.data.Hymn

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HymnsScreen(
    viewModel: HymnsViewModel = viewModel()
) {
    val hymns by viewModel.filteredHymns.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    val onlyShowFavorites by viewModel.onlyShowFavorites.collectAsState()
    val favoriteNumbers by viewModel.favoriteHymnNumbers.collectAsState()
    val selectedHymn by viewModel.selectedHymn.collectAsState()
    val fontSize by viewModel.fontSize.collectAsState()
    val keepScreenOn by viewModel.keepScreenOn.collectAsState()

    val context = LocalContext.current

    // Keep screen on effect
    LaunchedEffect(keepScreenOn) {
        val activity = context as? Activity
        if (activity != null) {
            if (keepScreenOn) {
                activity.window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
            } else {
                activity.window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
            }
        }
    }

    // Intercept back key to return to lists if a hymn is opened
    if (selectedHymn != null) {
        BackHandler {
            viewModel.selectHymn(null)
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.safeDrawing,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Jesu ndiIshe",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                },
                navigationIcon = {
                    if (selectedHymn != null) {
                        IconButton(
                            onClick = { viewModel.selectHymn(null) },
                            modifier = Modifier.testTag("back_to_list_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Dzokera kumashure (Back)"
                            )
                        }
                    }
                },
                actions = {
                    IconButton(
                        onClick = { viewModel.setOnlyShowFavorites(!onlyShowFavorites) },
                        modifier = Modifier.testTag("toggle_favorites_toolbar")
                    ) {
                        Icon(
                            imageVector = if (onlyShowFavorites) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Zvaunofarira (Favorites)",
                            tint = if (onlyShowFavorites) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { innerPadding ->
        AnimatedContent(
            targetState = selectedHymn,
            transitionSpec = {
                fadeIn(animationSpec = tween(300)) with fadeOut(animationSpec = tween(300))
            },
            modifier = Modifier.padding(innerPadding)
        ) { hymn ->
            if (hymn != null) {
                HymnDetailView(
                    hymn = hymn,
                    fontSize = fontSize,
                    isFavorite = favoriteNumbers.contains(hymn.number),
                    keepScreenOn = keepScreenOn,
                    onToggleFavorite = { viewModel.toggleFavorite(hymn.number) },
                    onToggleKeepScreenOn = { viewModel.toggleKeepScreenOn() },
                    onIncreaseFont = { viewModel.setFontSize(fontSize + 2f) },
                    onDecreaseFont = { viewModel.setFontSize(fontSize - 2f) }
                )
            } else {
                HymnsListView(
                    hymns = hymns,
                    searchQuery = searchQuery,
                    selectedCategory = selectedCategory,
                    onlyShowFavorites = onlyShowFavorites,
                    favoriteNumbers = favoriteNumbers,
                    onSearchQueryChanged = { viewModel.setSearchQuery(it) },
                    onCategorySelected = { viewModel.setSelectedCategory(it) },
                    onToggleFavorite = { viewModel.toggleFavorite(it) },
                    onHymnSelected = { viewModel.selectHymn(it) }
                )
            }
        }
    }
}

@Composable
fun HymnsListView(
    hymns: List<Hymn>,
    searchQuery: String,
    selectedCategory: String,
    onlyShowFavorites: Boolean,
    favoriteNumbers: Set<Int>,
    onSearchQueryChanged: (String) -> Unit,
    onCategorySelected: (String) -> Unit,
    onToggleFavorite: (Int) -> Unit,
    onHymnSelected: (Hymn) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        // Hero Header Image / Card Area
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
            // Check for generated drawable and fall back to solid/gradient if not resolved
            val bannerPainter = painterResource(id = R.drawable.img_hymn_banner_1782433829616)
            Image(
                painter = bannerPainter,
                contentDescription = "Hymn book banner illustration",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Warm gradient overlays for readability and premium look
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f))
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = "Jesu NdiIshe Hymns",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "“Imbirai Jehovha, rumbidzai zita rake”",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 12.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Search text field (Professional Polish rounded-full search bar)
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChanged,
            placeholder = { Text("Tsvaka rwiyo (Search number, title, words...)") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Tsvaka") },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { onSearchQueryChanged("") }) {
                        Icon(Icons.Default.Close, contentDescription = "Bvisa zvese")
                    }
                }
            },
            shape = RoundedCornerShape(28.dp), // rounded-full style from HTML
            modifier = Modifier
                .fillMaxWidth()
                .testTag("hymn_search_bar"),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedLeadingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                unfocusedLeadingIconColor = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Language categories horizontal row (Professional Polish style)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val categories = listOf("ALL", "SHONA", "CHEWA", "NDEBELE")
            categories.forEach { category ->
                val isSelected = selectedCategory == category
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp)) // rounded-lg
                        .background(
                            if (isSelected) MaterialTheme.colorScheme.secondary
                            else MaterialTheme.colorScheme.background
                        )
                        .border(
                            width = 1.dp,
                            color = if (isSelected) Color.Transparent else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clickable { onCategorySelected(category) }
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .testTag("filter_chip_$category")
                ) {
                    Text(
                        text = if (category == "ALL") "Dzese (All)" else category,
                        color = if (isSelected) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.onSurfaceVariant,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Empty state indicator
        if (hymns.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(32.dp)
                ) {
                    Text(
                        text = "📖",
                        fontSize = 48.sp
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Hapana nziyo dzakawanikwa",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Edza kunyora zvimwe (Try searching with other numbers or words)",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                        textAlign = TextAlign.Center
                    )
                }
            }
        } else {
            // Hymn lists in LazyColumn
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .testTag("hymns_lazy_list"),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(hymns) { hymn ->
                    val isFav = favoriteNumbers.contains(hymn.number)
                    HymnListItem(
                        hymn = hymn,
                        isFavorite = isFav,
                        onToggleFavorite = { onToggleFavorite(hymn.number) },
                        onHymnSelected = { onHymnSelected(hymn) }
                    )
                }
            }
        }
    }
}

@Composable
fun HymnListItem(
    hymn: Hymn,
    isFavorite: Boolean,
    onToggleFavorite: () -> Unit,
    onHymnSelected: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onHymnSelected() }
            .testTag("hymn_card_${hymn.number}"),
        shape = RoundedCornerShape(16.dp), // rounded-2xl
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Number badge (rounded-xl, 40.dp)
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = String.format("%03d", hymn.number), // zero padded e.g. 001, 042, 108
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Title and subtitles
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = hymn.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(2.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    // Category Language Badge
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(
                                when (hymn.category) {
                                    "SHONA" -> MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                                    "CHEWA" -> MaterialTheme.colorScheme.tertiary.copy(alpha = 0.1f)
                                    else -> MaterialTheme.colorScheme.secondary.copy(alpha = 0.15f)
                                }
                            )
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = hymn.category,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = when (hymn.category) {
                                "SHONA" -> MaterialTheme.colorScheme.primary
                                "CHEWA" -> MaterialTheme.colorScheme.tertiary
                                else -> MaterialTheme.colorScheme.secondary
                            }
                        )
                    }

                    if (hymn.englishTitle != null) {
                        Text(
                            text = hymn.englishTitle,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                            fontStyle = FontStyle.Italic
                        )
                    } else if (hymn.key.isNotEmpty()) {
                        Text(
                            text = hymn.key,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Favoriting Heart Icon (has touch target > 48dp)
            IconButton(
                onClick = onToggleFavorite,
                modifier = Modifier
                    .size(48.dp)
                    .testTag("heart_icon_${hymn.number}")
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Farira rwiyo",
                    tint = if (isFavorite) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
                )
            }

            // Right Chevron Arrow Indicator (Professional Polish design style)
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Details",
                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                modifier = Modifier
                    .padding(end = 4.dp)
                    .size(18.dp)
                    .rotate(180f)
            )
        }
    }
}

@Composable
fun HymnDetailView(
    hymn: Hymn,
    fontSize: Float,
    isFavorite: Boolean,
    keepScreenOn: Boolean,
    onToggleFavorite: () -> Unit,
    onToggleKeepScreenOn: () -> Unit,
    onIncreaseFont: () -> Unit,
    onDecreaseFont: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Controls / Options Bar at the top of detail screen
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Screen awake lock toggle
            TextButton(
                onClick = onToggleKeepScreenOn,
                colors = ButtonDefaults.textButtonColors(
                    contentColor = if (keepScreenOn) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                ),
                modifier = Modifier.testTag("screen_awake_toggle")
            ) {
                Text(
                    text = if (keepScreenOn) "🔆 Screen On" else "💤 Normal Screen",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // FontSize Increase/Decrease
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Size:",
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
                IconButton(
                    onClick = onDecreaseFont,
                    modifier = Modifier.size(36.dp).testTag("font_dec_btn")
                ) {
                    Text("-A", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                }
                IconButton(
                    onClick = onIncreaseFont,
                    modifier = Modifier.size(36.dp).testTag("font_inc_btn")
                ) {
                    Text("+A", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Favoriting in detail screen
            IconButton(
                onClick = onToggleFavorite,
                modifier = Modifier.size(48.dp).testTag("detail_heart_icon")
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Farira",
                    tint = if (isFavorite) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                )
            }
        }

        Divider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.12f))

        // Scrollable Hymn Sheet / Parchment Area
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .testTag("hymn_sheet_detail"),
            contentPadding = PaddingValues(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(12.dp))

                // Big Centered Badge with hymn number
                Box(
                    modifier = Modifier
                        .size(54.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.08f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = hymn.number.toString(),
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Title
                Text(
                    text = hymn.title,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                if (hymn.englishTitle != null) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "(${hymn.englishTitle})",
                        fontSize = 14.sp,
                        fontStyle = FontStyle.Italic,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                // Key signatures
                Text(
                    text = hymn.key,
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(24.dp))
            }

            // Hymn lyric verses
            items(hymn.lyrics) { verse ->
                val isChorus = verse.startsWith("Chorus:") || verse.startsWith("KORASI:") || verse.startsWith("CHORUS:")
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isChorus) {
                            MaterialTheme.colorScheme.secondary.copy(alpha = 0.07f)
                        } else {
                            MaterialTheme.colorScheme.surface.copy(alpha = 0.5f)
                        }
                    ),
                    border = if (isChorus) {
                        BorderStroke(1.dp, MaterialTheme.colorScheme.secondary.copy(alpha = 0.25f))
                    } else null
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = verse,
                            fontSize = fontSize.sp,
                            lineHeight = (fontSize * 1.45f).sp,
                            color = MaterialTheme.colorScheme.onSurface,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = if (isChorus) FontWeight.Medium else FontWeight.Normal,
                            textAlign = if (isChorus) TextAlign.Center else TextAlign.Left,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(40.dp))
                Divider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.1f), modifier = Modifier.width(100.dp))
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Amen",
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f)
                )
                Spacer(modifier = Modifier.height(60.dp))
            }
        }
    }
}
