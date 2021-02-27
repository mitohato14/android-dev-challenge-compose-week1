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

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.datasource.DataSource
import com.example.androiddevchallenge.util.SingleLiveEvent

/**
 * Created by mitohato14 on 2021/02/26.
 */
class PuppyListViewModel : ViewModel() {
    private val _puppyList: MutableLiveData<List<PuppyListBindingModel>> = MutableLiveData()
    val puppyList: LiveData<List<PuppyListBindingModel>> = _puppyList

    private val _navigateToDetail: SingleLiveEvent<Long> = SingleLiveEvent()
    val navigateToDetail: LiveData<Long>
        get() = _navigateToDetail

    init {
        _puppyList.value = DataSource.getPuppyListAll().map {
            PuppyListBindingModel(
                id = it.id,
                name = it.name,
                iconImageUrl = it.iconImageUrl,
                age = it.age,
                breed = it.breed,
                adoptionCenterName = it.adoptionCenter.name
            )
        }
    }

    fun onClickPuppy(id: Long) {
        _navigateToDetail.value = id
    }
}
