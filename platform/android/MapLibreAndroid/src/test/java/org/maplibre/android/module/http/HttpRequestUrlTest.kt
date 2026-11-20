package org.maplibre.android.module.http

import org.maplibre.android.MapLibreInjector
import org.maplibre.android.http.HttpRequestUrl
import org.maplibre.android.utils.ConfigUtils
import io.mockk.mockk
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.maplibre.android.BaseTest
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class HttpRequestUrlTest : BaseTest() {

    @Before
    fun setUp() {
        MapLibreInjector.inject(mockk(relaxed = true), "pk.foobar", ConfigUtils.getMockedOptions())
    }

    @Test
    fun testOfflineFlagOutdooractiveCom() {
        val expected = "http://outdooractive.com/path/of/no/return.pbf?offline=true"
        val actual = HttpRequestUrl.buildResourceUrl("outdooractive.com", "http://outdooractive.com/path/of/no/return.pbf", 0, true)
        assertEquals(expected, actual)
    }

    @Test
    fun testOfflineFlagOastaticCom() {
        val expected = "http://oastatic.com/path/of/no/return.pbf?offline=true"
        val actual = HttpRequestUrl.buildResourceUrl("oastatic.com", "http://oastatic.com/path/of/no/return.pbf", 0, true)
        assertEquals(expected, actual)
    }

    @Test
    fun testOfflineFlagInvalidHost() {
        val expected = "http://foobar.com/path/of/no/return.pbf"
        val actual = HttpRequestUrl.buildResourceUrl("foobar.com", "http://foobar.com/path/of/no/return.pbf", 0, true)
        assertEquals(expected, actual)
    }

    @Test
    fun testOnlineInvalidHost() {
        val expected = "http://foobar.com/path/of/no/return.pbf"
        val actual = HttpRequestUrl.buildResourceUrl("foobar.com", "http://foobar.com/path/of/no/return.pbf", 0, false)
        assertEquals(expected, actual)
    }

    @After
    fun tearDown() {
        MapLibreInjector.clear()
    }
}
