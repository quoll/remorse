# kmorse
Keyword to morse code conversion

## Usage

### Dependencies
This can be included in `deps.edn` with the following entry in the `:deps` map:

```clojure
com.github.quoll/kmorse {:git/tag "0.0.1" :git/sha "3b0cce9"}
```

### Keywords
Keywords can be converted to and from morse code.

```clojure
=> (require '[kmorse.core :as km])
nil

=> (km/keyword->morse :hello)
:...._._.-.._.-.._---

=> (km/keyword->morse :my/hello-world)
:my/...._._.-.._.-.._---_-....-_.--_---_.-._.-.._-..

=> (km/morse->keyword :...._._.-.._.-.._---)
:hello

=> (km/morse->keyword :my/...._._.-.._.-.._---_-....-_.--_---_.-._.-.._-..)
:my/hello-world
```

### Strings
Strings can also be converted. Leading and trailing spaces will be dropped.

```clojure
=> (km/morse->string "...._._.-.._.-.._---")
"hello"

=> (km/string->morse "hello world")
"...._._.-.._.-.._---__.--_---_.-._.-.._-.."

=> (km/morse->string "...._._.-.._.-.._---__.--_---_.-._.-.._-..")
"hello world"
```

# License
Copyright © 2022 Paula Gearon
Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
