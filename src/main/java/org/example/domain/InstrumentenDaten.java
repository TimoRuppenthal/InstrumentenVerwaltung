
package org.example.domain;

import io.jexxa.addend.applicationcore.ValueObject;

@ValueObject
public record InstrumentenDaten(String instrumentenart, int preis, String marke) {
}
