package com.example.unittesting.viewmodel

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.unittesting.models.Data
import com.example.unittesting.storage.Repository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock

@RunWith(AndroidJUnit4::class)
class MyViewModelTest {

    @Mock
    private lateinit var repository: Repository
    @Mock
    private lateinit var viewModel: MyViewModel

    @Before
    fun beforeTest(){
        val context: Context = InstrumentationRegistry
            .getInstrumentation()
            .context
        repository = Repository(context)
        viewModel = MyViewModel(repository)
    }

    @Test
    fun loadData() = runBlocking {
        val data1 = Data("Test2", "test2@gmail.com", 2)

        viewModel = MyViewModel(repository)
        val data = viewModel.loadData()

        if (data != null) {
            for (d in data) {
                assertEquals(data1.name, d.name)
            }
        }

    }
}