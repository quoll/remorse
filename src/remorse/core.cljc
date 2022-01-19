(ns ^{:doc "Provides function for converting strings to and from morse keywords"
      :author "Paula Gearon"}
    remorse.core
    (:require [clojure.string :as s]))

(def az->morse
  {\a ".-"
   \b "-..."
   \c "-.-."
   \d "-.."
   \e "."
   \f "..-."
   \g "--."
   \h "...."
   \i ".."
   \j ".---"
   \k "-.-"
   \l ".-.."
   \m "--"
   \n "-."
   \o "---"
   \p ".--."
   \q "--.-"
   \r ".-."
   \s "..."
   \t "-"
   \u "..-"
   \v "...-"
   \w ".--"
   \x "-..-"
   \y "-.--"
   \z "--.."
   \1 ".----"
   \2 "..---"
   \3 "...--"
   \4 "....-"
   \5 "....."
   \6 "-...."
   \7 "--..."
   \8 "---.."
   \9 "----."
   \0 "-----"
   \- "-....-"
   \+ ".-.-."
   \_ "..--.-"
   \! "..--."
   \? "..--.."
   \/ "-..-."
   \. ".-.-.-"
   \, "--..--"
   \" ".-..-."
   \' ".----."
   \: "---..."
   \; "-.-.-."
   \@ ".--.-."
   \% ".--.."
   \( "-.--."
   \) "-.--.-"
   \space ""})

(def morse->az (into {"" \space} (map (fn [[k v]] [v k]) az->morse)))

(defn string->morse
  [s]
  (->> (s/lower-case s)
       (map #(az->morse % %))
       (s/join "_")))

(defn morse->string
  [s]
  (->> (s/split s #"_")
       (map #(morse->az % %))
       (apply str)))

(defn convert-keyword
  [f k]
  (keyword (namespace k) (f (name k))))

(defn keyword->morse
  [k]
  (convert-keyword string->morse k))

(defn morse->keyword
  [k]
  (convert-keyword morse->string k))
