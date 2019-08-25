package com.alphateam.gshackchallenge.Utils.Controls;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.alphateam.gshackchallenge.R;

public enum EnumCatalogos {

    TRABAJO {
        @Override
        public String toString() {
            return "trabajo";
        }
    },
    MOTONETA {
        @Override
        public String toString() {
            return "motoneta";
        }
    },
    LINEAZ {
        @Override
        public String toString() {
            return "lineaZ";
        }
    },
    DEPORTIVA {
        @Override
        public String toString() {
            return "deportiva";
        }
    }, DOBLE {
        @Override
        public String toString() {
            return "doble";
        }
    },
    CUATRIMOTO {
        @Override
        public String toString() {
            return "cuatrimoto";
        }
    },
    CHOOPER {
        @Override
        public String toString() {
            return "chooper";
        }
    };

    /**
     * Se obtiene un Enum desde un id de comprobante.
     *
     * @param id Id asociado al enum.
     */
    public static EnumCatalogos getFromId(int id) {
        EnumCatalogos comprobantes = EnumCatalogos.TRABAJO;
        switch (id) {
            case 0: {
                comprobantes = EnumCatalogos.TRABAJO;
            }
            break;
            case 1: {
                comprobantes = EnumCatalogos.MOTONETA;
            }
            break;
            case 2: {
                comprobantes = EnumCatalogos.LINEAZ;
            }
            break;
            case 3: {
                comprobantes = EnumCatalogos.DEPORTIVA;
            }
            break;
            case 4: {
                comprobantes = EnumCatalogos.DOBLE;
            }
            break;
            case 5: {
                comprobantes = EnumCatalogos.CUATRIMOTO;
            }
            break;
            case 6: {
                comprobantes = EnumCatalogos.CHOOPER;
            }
            break;
            default: {
                comprobantes = EnumCatalogos.MOTONETA;
            }
            break;
        }
        return comprobantes;
    }

    /**
     * Obtiene la simbología del comprobante dependiendo de su estado
     *
     * @param comprobantes Enum del cual se quiere obtener
     */
    public static Drawable getDrawable(EnumCatalogos comprobantes, Context context) {
        Drawable image = null;
        switch (comprobantes) {
            case TRABAJO: {
                image = context.getDrawable(R.drawable.ic_trabajo);
            }
            break;
            case MOTONETA: {
                image = context.getDrawable(R.drawable.ic_motoneta);
            }
            break;
            case LINEAZ: {
                image = context.getDrawable(R.drawable.ic_lineaz);
            }
            break;
            case DEPORTIVA: {
                image = context.getDrawable(R.drawable.ic_deportiva);
            }
            break;
            case DOBLE: {
                image = context.getDrawable(R.drawable.ic_doble);
            }
            break;
            case CUATRIMOTO: {
                image = context.getDrawable(R.drawable.ic_cuatrimoto);
            }
            break;
            case CHOOPER: {
                image = context.getDrawable(R.drawable.ic_chooper);
            }
            break;
        }
        return image;
    }
}