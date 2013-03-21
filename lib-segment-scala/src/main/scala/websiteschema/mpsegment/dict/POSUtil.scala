package websiteschema.mpsegment.dict

object POSUtil {

  def getSize = posTable.size

  def getPOSIndex(s: String): Int = {
    val unknownPos = 44
    if (s != null && s.length() > 0) {
      posTable.get(s) match {
        case Some(pos) => return pos
        case _ => return unknownPos
      }
    }
    return unknownPos
  }

  def getPOSString(i: Int): String = {
    return posString(i)
  }

  def isSubstantive(i: Int): Boolean = {
    var flag = false
    if (i <= 11 || i >= 21 && i <= 23 || i >= 27 && i <= 30 || i >= 40 && i <= 43 || i == 44 || i == 33) {
      flag = true
    }
    return flag
  }

  def isUnknown(i: Int): Boolean = {
    var flag = false
    if (i == 44) {
      flag = true
    }
    return flag
  }

  def isNWord(i: Int): Boolean = {
    return i == 1 || i == 21 || i == 2 || i == 3 || i == 22 || i == 23 || i == 40 || i == 41 || i == 28 || i == 27 || i == 29 || i == 30 || i == 33 || i == 44 || i == 36
  }

  def isVWord(i: Int): Boolean = {
    return i == 9 || i == 34 || i == 40 || i == 42
  }

  def isAWord(i: Int): Boolean = {
    return i == 10 || i == 7 || i == 11 || i == 35 || i == 41 || i == 43
  }

  def isDWord(i: Int): Boolean = {
    return i == 12 || i == 42 || i == 43
  }

  def isILWord(i: Int): Boolean = {
    return i == 19 || i == 20
  }

  val POS_N = 1
  val POS_T = 2
  val POS_S = 3
  val POS_F = 4
  val POS_M = 5
  val POS_Q = 6
  val POS_B = 7
  val POS_R = 8
  val POS_V = 9
  val POS_A = 10
  val POS_Z = 11
  val POS_D = 12
  val POS_P = 13
  val POS_C = 14
  val POS_U = 15
  val POS_Y = 16
  val POS_E = 17
  val POS_O = 18
  val POS_I = 19
  val POS_L = 20
  val POS_J = 21
  val POS_H = 22
  val POS_K = 23
  val POS_G = 24
  val POS_X = 25
  val POS_W = 26
  val POS_NR = 27
  val POS_NS = 28
  val POS_NT = 29
  val POS_NZ = 30
  val POS_NX = 31
  val POS_NG = 33
  val POS_VG = 34
  val POS_AG = 35
  val POS_TG = 36
  val POS_DG = 37
  val POS_OG = 38
  val POS_AUX = 39
  val POS_VN = 40
  val POS_AN = 41
  val POS_VD = 42
  val POS_AD = 43
  val POS_UNKOWN = 44


  val posTable = scala.collection.mutable.Map[String, Int]()
  val posString = new Array[String](50)
  posTable += ("N" -> 1)
  posTable += ("T" -> 2)
  posTable += ("S" -> 3)
  posTable += ("F" -> 4)
  posTable += ("M" -> 5)
  posTable += ("Q" -> 6)
  posTable += ("B" -> 7)
  posTable += ("R" -> 8)
  posTable += ("V" -> 9)
  posTable += ("A" -> 10)
  posTable += ("Z" -> 11)
  posTable += ("D" -> 12)
  posTable += ("P" -> 13)
  posTable += ("C" -> 14)
  posTable += ("U" -> 15)
  posTable += ("Y" -> 16)
  posTable += ("E" -> 17)
  posTable += ("O" -> 18)
  posTable += ("I" -> 19)
  posTable += ("L" -> 20)
  posTable += ("J" -> 21)
  posTable += ("H" -> 22)
  posTable += ("K" -> 23)
  posTable += ("G" -> 24)
  posTable += ("X" -> 25)
  posTable += ("W" -> 26)
  posTable += ("NR" -> 27)
  posTable += ("NS" -> 28)
  posTable += ("NT" -> 29)
  posTable += ("NZ" -> 30)
  posTable += ("NX" -> 31)
  posTable += ("NG" -> 33)
  posTable += ("VG" -> 34)
  posTable += ("AG" -> 35)
  posTable += ("TG" -> 36)
  posTable += ("DG" -> 37)
  posTable += ("OG" -> 38)
  posTable += ("VN" -> 40)
  posTable += ("AN" -> 41)
  posTable += ("VD" -> 42)
  posTable += ("AD" -> 43)
  posTable += ("UN" -> 44)
  posTable += ("NUM" -> 5)
  posTable += ("ADJ" -> 10)
  posTable += ("PUNC" -> 26)
  posTable += ("ECHO" -> 18)
  posTable += ("ADV" -> 12)
  posTable += ("CLAS" -> 6)
  posTable += ("PRON" -> 8)
  posTable += ("PREP" -> 13)
  posTable += ("STRU" -> 15)
  posTable += ("EXPR" -> 16)
  posTable += ("CONJ" -> 14)
  posTable += ("COOR" -> 14)
  posTable += ("PREFIX" -> 22)
  posTable += ("SUFFIX" -> 23)
  posTable += ("AUX" -> 9)
  posTable += ("n" -> 1)
  posTable += ("t" -> 2)
  posTable += ("s" -> 3)
  posTable += ("f" -> 4)
  posTable += ("m" -> 5)
  posTable += ("q" -> 6)
  posTable += ("b" -> 7)
  posTable += ("r" -> 8)
  posTable += ("v" -> 9)
  posTable += ("a" -> 10)
  posTable += ("z" -> 11)
  posTable += ("d" -> 12)
  posTable += ("p" -> 13)
  posTable += ("c" -> 14)
  posTable += ("u" -> 15)
  posTable += ("y" -> 16)
  posTable += ("e" -> 17)
  posTable += ("o" -> 18)
  posTable += ("i" -> 19)
  posTable += ("l" -> 20)
  posTable += ("j" -> 21)
  posTable += ("h" -> 22)
  posTable += ("k" -> 23)
  posTable += ("g" -> 24)
  posTable += ("x" -> 25)
  posTable += ("w" -> 26)
  posTable += ("nr" -> 27)
  posTable += ("ns" -> 28)
  posTable += ("nt" -> 29)
  posTable += ("nz" -> 30)
  posTable += ("nx" -> 31)
  posTable += ("ng" -> 33)
  posTable += ("vg" -> 34)
  posTable += ("ag" -> 35)
  posTable += ("tg" -> 36)
  posTable += ("dg" -> 37)
  posTable += ("og" -> 38)
  posTable += ("vn" -> 40)
  posTable += ("an" -> 41)
  posTable += ("vd" -> 42)
  posTable += ("ad" -> 43)
  posTable += ("un" -> 44)
  posTable += ("num" -> 5)
  posTable += ("adj" -> 10)
  posTable += ("punc" -> 26)
  posTable += ("echo" -> 18)
  posTable += ("adv" -> 12)
  posTable += ("clas" -> 6)
  posTable += ("pron" -> 8)
  posTable += ("prep" -> 13)
  posTable += ("stru" -> 15)
  posTable += ("expr" -> 16)
  posTable += ("conj" -> 14)
  posTable += ("coor" -> 14)
  posTable += ("prefix" -> 22)
  posTable += ("suffix" -> 23)
  posTable += ("aux" -> 9)
  posString(1) = "N"
  posString(2) = "T"
  posString(3) = "S"
  posString(4) = "F"
  posString(5) = "M"
  posString(6) = "Q"
  posString(7) = "B"
  posString(8) = "R"
  posString(9) = "V"
  posString(10) = "A"
  posString(11) = "Z"
  posString(12) = "D"
  posString(13) = "P"
  posString(14) = "C"
  posString(15) = "U"
  posString(16) = "Y"
  posString(17) = "E"
  posString(18) = "O"
  posString(19) = "I"
  posString(20) = "L"
  posString(21) = "J"
  posString(22) = "H"
  posString(23) = "K"
  posString(24) = "G"
  posString(25) = "X"
  posString(26) = "W"
  posString(27) = "NR"
  posString(28) = "NS"
  posString(29) = "NT"
  posString(30) = "NZ"
  posString(31) = "NX"
  posString(33) = "NG"
  posString(34) = "VG"
  posString(35) = "AG"
  posString(36) = "TG"
  posString(37) = "DG"
  posString(38) = "OG"
  posString(40) = "VN"
  posString(41) = "AN"
  posString(42) = "VD"
  posString(43) = "AD"
  posString(39) = "AUX"
  posString(44) = "UN"


}

/*

---- 附北大词性标注版本 ----
Ag
形语素
形容词性语素。形容词代码为a，语素代码ｇ前面置以A。

A
形容词
取英语形容词adjective的第1个字母。

AD
副形词
直接作状语的形容词。形容词代码a和副词代码d并在一起。

AN
名形词
具有名词功能的形容词。形容词代码a和名词代码n并在一起。

B
区别词
取汉字“别”的声母。

C
连词
取英语连词conjunction的第1个字母。

Dg
副语素
副词性语素。副词代码为d，语素代码ｇ前面置以D。

D
副词
取adverb的第2个字母，因其第1个字母已用于形容词。

E
叹词
取英语叹词exclamation的第1个字母。

F
方位词
取汉字“方”

G
语素
绝大多数语素都能作为合成词的“词根”，取汉字“根”的声母。

H
前接成分
取英语head的第1个字母。

I
成语
取英语成语idiom的第1个字母。

J
简称略语
取汉字“简”的声母。

K
后接成分
　
L
习用语
习用语尚未成为成语，有点“临时性”，取“临”的声母。

M
数词
取英语numeral的第3个字母，n，u已有他用。

Ng
名语素
名词性语素。名词代码为n，语素代码ｇ前面置以N。

N
名词
取英语名词noun的第1个字母。

Nr
人名
名词代码n和“人(ren)”的声母并在一起。

Ns
地名
名词代码n和处所词代码s并在一起。

Nt
机构团体
“团”的声母为t，名词代码n和t并在一起。

Nz
其他专名
“专”的声母的第1个字母为z，名词代码n和z并在一起。

O
拟声词
取英语拟声词onomatopoeia的第1个字母。

ba 介词 把、将 　
bei 介词 被 　


P
介词
取英语介词prepositional的第1个字母。

Q
量词
取英语quantity的第1个字母。

R
代词
取英语代词pronoun的第2个字母,因p已用于介词。

S
处所词
取英语space的第1个字母。

Tg
时语素
时间词性语素。时间词代码为t,在语素的代码g前面置以T。

T
时间词
取英语time的第1个字母。

dec 助词 的、之 　
deg 助词 得 　
di 助词 地 　
etc 助词 等、等等 　
as 助词 了、着、过 　
msp 助词 所 　

U
其他助词
取英语助词auxiliary

Vg
动语素
动词性语素。动词代码为v。在语素的代码g前面置以V。

V
动词
取英语动词verb的第一个字母。

Vd
副动词
直接作状语的动词。动词和副词的代码并在一起。

Vn
名动词
指具有名词功能的动词。动词和名词的代码并在一起。

W
其他标点符号
　
X
非语素字
非语素字只是一个符号，字母x通常用于代表未知数、符号。

Y
语气词
取汉字“语”的声母。

Z
状态词
取汉字“状”的声母的前一个字母。
* */