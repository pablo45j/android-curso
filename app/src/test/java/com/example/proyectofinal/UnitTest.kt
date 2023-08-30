package com.example.proyectofinal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class UnitTest {
    private lateinit var viewModel: ViewModelMain

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        viewModel = ViewModelMain()
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        val value1 = viewModel.texts.value?.texto1
        val value2 = viewModel.texts.value?.texto2
        assertEquals("",value1)
        assertEquals("",value2)

    }

    @Test
    fun mainViewModel_CheckCompare() = runTest {
        val value1 = "Hola"
        val value2 = "Holas"
        viewModel.setTexts(value1, value2)
        val result = viewModel.compareTexts()
        assertEquals("NO SON IGUALES LAS CADENAS",result)


    }
}