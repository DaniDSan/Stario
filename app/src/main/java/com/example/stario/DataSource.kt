package com.example.stario

class DataSource {
    fun loadAffirmations(): List<FilmImgName> {
        return listOf<FilmImgName>(
            FilmImgName(R.drawable.the_phantom_menace),
            FilmImgName(R.drawable.attack_of_the_clones),
            FilmImgName(R.drawable.revenge_of_the_sith),
            FilmImgName(R.drawable.a_new_hope),
            FilmImgName(R.drawable.the_empire_strikes_back),
            FilmImgName(R.drawable.return_of_the_jedi)
        )
    }
}