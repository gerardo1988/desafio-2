package com.example.mutante.services;

import org.springframework.stereotype.Service;

@Service
public class MutanteService implements BaseService {


    @Override
    public boolean buscaMutante(String[][] m) throws Exception {

        boolean cadenaHorizontal, cadenaVertical, cadenaDiagonal;
        int contadorMutante = 0;
        boolean esMutante;
        try {
            //busco en el sentido de las filas
            for (int i = 0; i < m.length; i++) {

                cadenaHorizontal = false;

                for (int j = 0; j < m[0].length - 3; j++) {

                    if (m[i][j] == "A" || m[i][j] == "G" || m[i][j] == "T" || m[i][j] == "C") {

                        if (m[i][j] == m[i][j + 1] && m[i][j] == m[i][j + 2] && m[i][j] == m[i][j + 3]) {

                            cadenaHorizontal = true;

                            if (cadenaHorizontal) {

                                contadorMutante++;
                            }

                        }
                    }
                }

            }

            //busco en el sentido de las columnas
            for (int j = 0; j < m[0].length; j++) {

                cadenaVertical = false;

                for (int i = 0; i < m.length - 3; i++) {

                    if (m[i][j] == "A" || m[i][j] == "G" || m[i][j] == "T" || m[i][j] == "C") {

                        if (m[i][j] == m[i + 1][j] && m[i][j] == m[i + 2][j] && m[i][j] == m[i + 3][j]) {

                            cadenaVertical = true;

                            if (cadenaVertical) {

                                contadorMutante++;
                            }

                        }
                    }

                }

            }

            //busco en el sentido de las diagonales
            for (int i = 0; i < m.length - 2; i++) {

                cadenaDiagonal = false;

                for (int j = 0; j < m[0].length - 2; j++) {

                    if (m[i][j] == "A" || m[i][j] == "G" || m[i][j] == "T" || m[i][j] == "C") {

                        if (m[i][j] == m[i + 1][j + 1] && m[i][j] == m[i + 2][j + 2] && m[i][j] == m[i + 3][j + 3]) {

                            cadenaDiagonal = true;

                            if (cadenaDiagonal) {

                                contadorMutante++;

                            }

                        }
                    }

                }
            }

            //si hay mas de una cadena de mutante dara como resultado que hay un mutante
            if (contadorMutante >= 2) {

                esMutante = true;

            } else {

                esMutante = false;

            }

            return esMutante;

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }
}
