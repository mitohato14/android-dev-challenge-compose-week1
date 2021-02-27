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
package com.example.androiddevchallenge.datasource

import com.example.androiddevchallenge.domain.AdoptionCenter
import com.example.androiddevchallenge.domain.Breed
import com.example.androiddevchallenge.domain.Puppy

/**
 * Created by mitohato14 on 2021/02/27.
 */
object DataSource {
    private val puppyList: List<Puppy> =
        listOf(
            Puppy(
                id = 0,
                name = "Akita",
                iconImageUrl = null,
                imageUrlList = listOf(
                    "placeholder"
                ),
                age = 0,
                breed = Breed.Akita,
                adoptionCenter = AdoptionCenter(
                    name = "Tokyo center",
                    locationAddress = "Tokyo location address",
                    emailAddress = "Tokyo email address"
                )
            ),
            Puppy(
                id = 1,
                name = "Collie",
                iconImageUrl = null,
                imageUrlList = listOf(
                    "placeholder",
                    "placeholder",
                    "placeholder",
                ),
                age = 1,
                breed = Breed.Collie,
                adoptionCenter = AdoptionCenter(
                    name = "Scotland center",
                    locationAddress = "Scotland location address",
                    emailAddress = "Scotland email address"
                )
            ),
            Puppy(
                id = 2,
                name = "Corgi",
                iconImageUrl = null,
                imageUrlList = listOf(),
                age = 0,
                breed = Breed.Corgi,
                adoptionCenter = AdoptionCenter(
                    name = "Wales center",
                    locationAddress = "Wales location address",
                    emailAddress = "Wales email address"
                )
            ),
            Puppy(
                id = 3,
                name = "GoldenRetriever",
                iconImageUrl = null,
                imageUrlList = listOf(
                    "placeholder",
                    "placeholder",
                ),
                age = 0,
                breed = Breed.GoldenRetriever,
                adoptionCenter = AdoptionCenter(
                    name = "UK center",
                    locationAddress = "UK location address",
                    emailAddress = "UK email address"
                )
            ),
            Puppy(
                id = 4,
                name = "Shepherd",
                iconImageUrl = null,
                imageUrlList = listOf(
                    "placeholder",
                    "placeholder",
                    "placeholder",
                    "placeholder",
                    "placeholder",
                ),
                age = 1,
                breed = Breed.Shepherd,
                adoptionCenter = AdoptionCenter(
                    name = "Germany center",
                    locationAddress = "Germany location address",
                    emailAddress = "Germany email address"
                )
            )
        )

    fun getPuppyListAll(): List<Puppy> = puppyList

    fun getPuppyById(id: Long): Puppy = puppyList.first { it.id == id }
}
