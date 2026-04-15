package create.develop.moviemappers.data.star

import create.develop.moviemappers.data.DataService

class FetchLocalStarsService() : DataService<Star> {

    override suspend fun fetchStar(): List<Star> {
        return listOf(
            Star("Proxima Centauri", 4.24, "The closest known star to the Sun."),
            Star(
                "Alpha Centauri A & B",
                4.37,
                "A binary pair that, with Proxima, forms a triple system."
            ),
            Star("Barnard's Star", 5.96, "known for having the highest proper motion."),
            Star("Wolf 359", 7.78, "A very faint red dwarf in the constellation Leo."),
            Star("Sirius A", 8.6, "The brightest star in our night sky."),
            Star(
                "Rigel",
                860.0,
                "A blue supergiant in Orion, over 60,000 times as luminous as our Sun."
            ),
            Star(
                "Canopus",
                310.0,
                "The second brightest star in the sky, used for spacecraft navigation."
            ),
            Star("Betelgeuse", 640.0, "A massive red supergiant expected to go supernova soon.")
        ).sortedBy { it.distanceFromSun }
    }
}
