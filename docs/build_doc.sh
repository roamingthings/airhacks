#!/bin/sh

### you will have to install asciidoctor and asciidoctor-diagram
### `gem install coderay`
### `gem install asciidoctor`
### `gem install --pre asciidoctor-pdf`
### `gem install asciidoctor-diagram`

asciidoctor-pdf -r asciidoctor-diagram *.adoc