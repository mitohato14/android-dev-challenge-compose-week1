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
package com.example.androiddevchallenge.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.domain.Breed
import com.example.androiddevchallenge.ui.common.IconImage
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.gray500

/**
 * Created by mitohato14 on 2021/02/26.
 */

@Composable
fun PuppyListCompose() {
    val viewModel: PuppyListViewModel = viewModel()
    val puppyList: List<PuppyListBindingModel> by viewModel.puppyList.observeAsState(listOf())
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "PuppyAdoption") },
                    backgroundColor = MaterialTheme.colors.primary
                )
            },
            content = {
                PuppyList(
                    puppyListBindingModelList = puppyList,
                    clickPuppy = viewModel::onClickPuppy
                )
            }
        )
    }
}

@Composable
fun PuppyList(
    puppyListBindingModelList: List<PuppyListBindingModel>,
    clickPuppy: (id: Long) -> Unit
) {
    LazyColumn() {
        items(puppyListBindingModelList) {
            ListItem(
                puppyListBindingModel = it,
                clickPuppy = clickPuppy
            )
        }
    }
}

@Composable
fun ListItem(
    puppyListBindingModel: PuppyListBindingModel,
    clickPuppy: (id: Long) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp,
                horizontal = 8.dp
            )
            .clickable { clickPuppy(puppyListBindingModel.id) }
    ) {
        IconImage(
            iconImageUrl = puppyListBindingModel.iconImageUrl,
            modifier = Modifier
                .padding(8.dp)
                .size(45.dp)
        )
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = puppyListBindingModel.name,
                    style = TextStyle(fontSize = 24.sp)
                )
                Spacer(modifier = Modifier.size(10.dp))
                Text(
                    text = "Age: ${puppyListBindingModel.age}",
                    textAlign = TextAlign.Center,
                )
            }
            BreedTip(breed = puppyListBindingModel.breed)
            Spacer(modifier = Modifier.size(6.dp))
            Text(
                text = "Center: ${puppyListBindingModel.adoptionCenterName}",
                style = TextStyle(color = gray500)
            )
        }
    }
}

@Composable
fun BreedTip(breed: Breed) {
    Box(
        modifier = Modifier
            .background(
                color = breed.color,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Text(
            text = breed.name,
            modifier = Modifier.padding(
                vertical = 2.dp,
                horizontal = 6.dp
            ),
            style = TextStyle(fontSize = 8.sp)
        )
    }
}

@Preview("BreedTip", showBackground = true)
@Composable
fun BreedTipPreview() {
    MyTheme {
        BreedTip(breed = Breed.Akita)
    }
}

@Preview("puppy list", showBackground = true)
@Composable
fun PuppyListPreview() {
    MyTheme {
        PuppyList(
            puppyListBindingModelList = (0..10).map {
                PuppyListBindingModel(
                    id = it.toLong(),
                    name = "akita$it",
                    iconImageUrl = null,
                    age = it,
                    breed = Breed.Akita,
                    adoptionCenterName = "tokyo$it"
                )
            },
            clickPuppy = {}
        )
    }
}

@Preview("list item", showBackground = true)
@Composable
fun ListItemPreview() {
    MyTheme {
        ListItem(
            puppyListBindingModel = PuppyListBindingModel(
                id = 1,
                name = "akita",
                iconImageUrl = null,
                age = 2,
                breed = Breed.Akita,
                adoptionCenterName = "tokyo"
            ),
            clickPuppy = {}
        )
    }
}
