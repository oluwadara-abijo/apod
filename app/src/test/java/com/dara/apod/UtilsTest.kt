package com.dara.apod

import com.dara.apod.model.Picture
import org.junit.Test

class UtilsTest {

    /**
     * Checks that a json string is converted to an object
     */
    @Test
    fun jsonToObjectConversion_isToCorrectObject(){
        val jsonString = "    {\n" +
                "        \"copyright\": \"ESA/HubbleNASA\",\n" +
                "        \"date\": \"2019-12-01\",\n" +
                "        \"explanation\": \"Why does this galaxy have a ring of bright blue stars?  Beautiful island universe Messier 94 lies a mere 15 million light-years distant in the northern constellation of the Hunting Dogs (Canes Venatici). A popular target for Earth-based astronomers, the face-on spiral galaxy is about 30,000 light-years across, with spiral arms sweeping through the outskirts of its broad disk. But this Hubble Space Telescope field of view spans about 7,000 light-years across M94's central region. The featured close-up highlights the galaxy's compact, bright nucleus, prominent inner dust lanes, and the remarkable bluish ring of young massive stars. The ring stars are all likely less than 10 million years old, indicating that M94 is a starburst galaxy that is experiencing an epoch of rapid star formation from inspiraling gas. The circular ripple of blue stars is likely a wave propagating outward, having been triggered by the gravity and rotation of a oval matter distributions. Because M94 is relatively nearby, astronomers can better explore details of its starburst ring.    Astrophysicists: Browse 2,000+ codes in the Astrophysics Source Code Library\",\n" +
                "        \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/M94_Hubble_1002.jpg\",\n" +
                "        \"media_type\": \"image\",\n" +
                "        \"service_version\": \"v1\",\n" +
                "        \"title\": \"Starburst Galaxy M94 from Hubble\",\n" +
                "        \"url\": \"https://apod.nasa.gov/apod/image/1912/M94_Hubble_960.jpg\"\n" +
                "    }"
        val pictureObject = jsonToObject<Picture>(jsonString)
        assert(pictureObject.copyright == "ESA/HubbleNASA")
    }
}