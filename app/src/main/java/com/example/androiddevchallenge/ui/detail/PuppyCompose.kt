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
package com.example.androiddevchallenge.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.ui.common.IconImage
import com.example.androiddevchallenge.ui.common.ImageOrPlaceholder
import com.example.androiddevchallenge.ui.theme.MyTheme

/**
 * Created by mitohato14 on 2021/02/27.
 */

@Composable
fun PuppyFragmentCompose() {
    val viewModel: PuppyViewModel = viewModel()
    val puppy by viewModel.puppy.observeAsState()
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = puppy?.name ?: "Puppy") },
                    backgroundColor = MaterialTheme.colors.primary
                )
            },
            content = {
                puppy?.let {
                    PuppyContent(bindingModel = it)
                }
            }
        )
    }
}

@Composable
fun PuppyContent(bindingModel: PuppyBindingModel) {
    Column(modifier = Modifier.padding(8.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            IconImage(
                iconImageUrl = bindingModel.avatarIconImageUrl,
                modifier = Modifier
                    .padding(50.dp)
                    .size(100.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        BasicPuppyInformation(
            bindingModel = bindingModel,
            modifier = Modifier.padding(horizontal = 10.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        AdoptionCenterContent(
            adoptionCenterBindingModel = bindingModel.adoptionCenter,
            modifier = Modifier.padding(horizontal = 10.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        ImageHorizontalScollableList(imageUrlList = bindingModel.imageUrlList)
    }
}

@Composable
fun BasicPuppyInformation(
    bindingModel: PuppyBindingModel,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "Name: ${bindingModel.name}",
            style = MaterialTheme.typography.body1.copy(
                fontSize = 32.sp
            )
        )
        Text(
            text = "Age: ${bindingModel.age}",
            style = MaterialTheme.typography.body1.copy(
                fontSize = 24.sp
            )
        )
    }
}

@Composable
fun AdoptionCenterContent(
    adoptionCenterBindingModel: AdoptionCenterBindingModel,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "Center: ${adoptionCenterBindingModel.name}",
            style = MaterialTheme.typography.body1.copy(
                fontSize = 18.sp
            )
        )
        Text(
            text = "Location: ${adoptionCenterBindingModel.locationAddress}",
            style = MaterialTheme.typography.caption.copy(
                fontSize = 18.sp
            )
        )
        Text(
            text = "Email: ${adoptionCenterBindingModel.emailAddress}",
            style = MaterialTheme.typography.caption.copy(
                fontSize = 18.sp
            )
        )
    }
}

@Composable
fun ImageHorizontalScollableList(imageUrlList: List<String>) {
    LazyRow {
        items(imageUrlList) {
            Box(modifier = Modifier.padding(20.dp)) {
                ImageOrPlaceholder(
                    imageUrl = it,
                    modifier = Modifier.size(200.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PuppyComposePreview() {
    MyTheme {
        PuppyFragmentCompose()
    }
}
