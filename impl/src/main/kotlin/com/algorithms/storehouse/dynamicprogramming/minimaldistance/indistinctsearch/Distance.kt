package com.algorithms.storehouse.dynamicprogramming.minimaldistance.indistinctsearch

class Distance {
    var samples: ArrayList<LanguageSet> = ArrayList()

//    TODO datas what does it have inside ?
    fun setData(datas:List<Pair<String,String>>) {
        val codeKeys = Dictionaries.codeKeysRus + Dictionaries.codeKeysEng.toList()
        for(data in datas) {
            var languageSet = LanguageSet()
//            TODO what are we doing here ?
            languageSet.rus.original = data.first
            if (data.first.isNotEmpty()) {
//      TODO we're converting initial data to the lower registry + translate GetKeyCodes method
//                languageSet.rus.words = data.first.split(' ').Select(w => new Word() {
//                    Text = w.ToLower(),
//
//                    Codes = GetKeyCodes(codeKeys, w)
//                }).ToList();
            }

/*            languageSet.Eng.Origianl = data.Item2;
            if (data.Item2.Length > 0) {
                languageSet.Eng.Words = data.Item2.Split(' ').Select(w => new Word() {
                    Text = w.ToLower(),
                    Codes = GetKeyCodes(codeKeys, w)
                }).ToList();
            }
            this.Samples.Add(languageSet);*/
        }
    }
}