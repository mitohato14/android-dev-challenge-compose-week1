/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.androiddevchallenge.R
import dev.chrisbanes.accompanist.coil.CoilImage

/**
 * Created by mitohato14 on 2021/02/27.
 */
@Composable
fun IconImage(
    iconImageUrl: String?,
    modifier: Modifier = Modifier
) {
    Card(
        shape = CircleShape,
        modifier = modifier
    ) {
        ImageOrPlaceholder(imageUrl = iconImageUrl)
    }
}

@Composable
fun ImageOrPlaceholder(
    imageUrl: String?,
    modifier: Modifier = Modifier
) {
    if (imageUrl == null || imageUrl == "placeholder") {
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_pets_24),
            contentDescription = stringResource(id = R.string.list_item_default_icon_description),
            modifier = modifier
        )
    } else {
        CoilImage(
            data = imageUrl,
            contentDescription = stringResource(id = R.string.list_item_icon_description),
            modifier = modifier
        )
    }
}
