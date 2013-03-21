package websiteschema.mpsegment.dict.domain

import websiteschema.mpsegment.dict.{IWord, DomainWordItem, HashDictionary, IDictionary}

import collection.mutable

class DomainDictionary extends IDictionary {

  private def lookupWord(wordName: String): IWord = {
    return hashDictionary.lookupWord(wordName)
  }

  private def getWord(wordIndex: Int): IWord = {
    return if (wordIndex >= 0) arrayWordItem(wordIndex) else null
  }

  private def getWordIndex(wordName: String): Int = wordNameIndexHashMap.getOrElse(wordName, -1)

  private def addWord(wordName: String, pos: String, freq: Int, domainType: Int): Int = {
    val word = DomainWordItem(wordName, domainType)
    word.setOccuredCount(pos, freq)
    val index = arrayWordItem.size
    wordNameIndexHashMap += (wordName -> index)
    arrayWordItem = arrayWordItem ++ List(word)
    hashDictionary.addWord(word)
    if (wordName.length() > maxWordLength) {
      maxWordLength = wordName.length
    }
    return index
  }

  def pushWord(wordName: String, synonym: String, pos: String, freq: Int, domainType: Int) {
    if (wordName == null || wordName.trim().equals("") || pos == null || pos.trim().equals("") || wordName.trim().length() < 2) {
      System.err.println("Load a error word '" + wordName + "'into domain dictionary, already ignored.")
      return
    }
    val word = lookupWord(wordName)
    var index = -1
    if (null != word) {
      word.setOccuredCount(pos, freq)
      word.setDomainType(domainType)
      index = getWordIndex(wordName)
    } else {
      index = addWord(wordName, pos, freq, domainType)
    }
    if (null != synonym && !synonym.isEmpty()) {
      val synonymIndex = getWordIndex(synonym)
      addSynonym(index, synonymIndex)
    }
  }

  private def addSynonym(index: Int, synonymIndex: Int) {
    if (index >= 0 && synonymIndex >= 0) {
      synonymIndexHashMap += (index -> synonymIndex)
      var synonymSet = synonymHashMap.getOrElse(synonymIndex, null)
      if (null == synonymSet) {
        synonymSet = List[Int]()
      }
      if (!synonymSet.contains(index)) {
        synonymSet = synonymSet ++ List(index)
      }
      synonymHashMap += (synonymIndex -> synonymSet)
    }
  }

  def getSynonymSet(wordName: String): List[IWord] = {
    val index = getWordIndex(wordName)
    if (index >= 0) {
      val synonymIndex = synonymIndexHashMap.getOrElse(index, -1)
      val synonymSet: List[Int] =
        if (synonymIndex >= 0) synonymHashMap(synonymIndex) else synonymHashMap(index)
      if (null != synonymSet) {
        val head = getWord(if (synonymIndex >= 0) synonymIndex else index)
        return head :: synonymSet.map(i => getWord(i))
      }
    }
    return null
  }

  override def getWord(wordName: String): IWord = {
    return hashDictionary.getWord(wordName)
  }

  def getWordItem(wordName: String): IWord = {
    val minLength = 1
    val maxLength = if (wordName.length < maxWordLength) wordName.length else maxWordLength

    var length = maxLength
    while (length >= minLength) {
      val s2 = wordName.substring(0, length)
      val wordIndex = getWordIndex(s2)
      if (wordIndex > 0) {
        return getWord(wordIndex)
      }
      length -= 1
    }

    return null
  }

  override def getWords(wordStr: String): Array[IWord] = {
    return hashDictionary.getWords(wordStr)
  }

  override def iterator(): List[IWord] = {
    return arrayWordItem
  }

  private val hashDictionary = new HashDictionary()
  hashDictionary.setHeadLength(2)
  private val wordNameIndexHashMap = mutable.HashMap[String, Int]()
  private var arrayWordItem = List[DomainWordItem]()
  private val synonymIndexHashMap = mutable.HashMap[Int, Int]()
  private val synonymHashMap = mutable.HashMap[Int, List[Int]]()
  private var maxWordLength: Int = 0
}
