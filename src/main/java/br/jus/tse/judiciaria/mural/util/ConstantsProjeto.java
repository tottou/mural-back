package br.jus.tse.judiciaria.mural.util;

import br.jus.tse.corporativa.util.Constants;

public final class ConstantsProjeto extends Constants {

    private ConstantsProjeto() {
        super();
    }

    /**
     * INTERFACE PARA CONSTANTS NUMBERICOS.
     *
     * @since 1.0.0.0
     */
    public static final class NUMBER {

        private NUMBER() {
            super();
        }

        /**
         * VALOR INVALIDO.
         */
        public static final Integer VALOR_INVALIDO = 0;

        /**
         * VALOR A SER UTILIZADO PARA IGUALDADE PARA O METODO COMPARE.
         */
        public static final Integer VALOR_IGUALDADE_PARA_COMPARE_TO = 0;

        /**
         * ID INVALIDO.
         */
        public static final Long ID_INVALIDO = 0L;

        /**
         * PRIMEIRO INDICE DO ARRAY
         */
        public static final Integer PRIMEIRO_INDICE_ARRAY = 0;

        /**
         * SEGUNDO INDICE DO ARRAY
         */
        public static final Integer SEGUNDO_INDICE_ARRAY = 1;

        /**
         * VALOR DE INICIALIZACAO DE UMA INSTANCIA DO STRING BUILD.
         */
        public static final Integer VALOR_INICIALIZACAO_STRING_BUILDER = 1024;
    }

    /**
     * CONSTANTS TO LOCALE
     *
     * @since 1.0.0.0
     */
    public static final class LOCALE {

        private LOCALE() {
            super();
        }

        /**
         * LANGUAGE PORTUGUESE.
         */
        public static final String LINGUA_PORTUGUESA = "pt";

        /**
         * COUNTRY BRAZIL.
         */
        public static final String PAIS_BRASIL = "BR";
    }

    /**
     * CONSTANTES PARA CARACTERES.
     *
     * @since 1.0.0.0
     */
    public static final class CARACTER {

        private CARACTER() {
            super();
        }

        public static final String PERCENT = "%";

        public static final String SEMI_COLON = ";";

        public static final String COMMA = ",";

        public static final String EMPTY_SPACE = " ";

        /**
         * PARENTESE ESQUERDO (
         */
        public static final String LEFT_PARENTESE = "(";

        /**
         * PARENTESE DIREITO )
         */
        public static final String RIGHT_PARENTESE = ")";

        /**
         * HIFFEN -
         */
        public static final String HIFFEN = "-";

        /**
         * QUEBRA DE LINHA - BARRA n.
         */
        public static final String QUEBRA_LINHA = "\n";

        /**
         * STRING VAZIA.
         */
        public static final String STRING_VAZIA = "";

        /**
         * PACOTE A SER SCANEADO PELO SPRING PARA CLASSES DE ACESSO À BASE DE DADOS.
         */
        public static final String SCAN_PACOTE_DAO = "br.jus.tse.judiciaria.mural.dao";

        /**
         * PACOTE BASE DA APLICAÇÃO A SER SCANEADO PELO SPRING PARA GERENCIAR OS BEANS.
         */
        public static final String SCAN_PACOTE_BASE_PROJETO = "br.jus.tse.judiciaria.mural";
        
        /**
         * PACOTE DE ENTIDADES DA APLICAÇÃO A SER SCANEADO PELO SPRING PARA GERENCIAR OS BEANS.
         */
        public static final String SCAN_PACOTE_ENTIDADE = "br.jus.tse.judiciaria.mural.entidade";
    }

    /**
     * CONSTANTS TO USE IN CLASSES REST.
     *
     * @since 1.0.0.0
     */
    public static final class ENTITY {

        private ENTITY() {
            super();
        }

        public static final String SCHEMA = "ADMMURAL_JE";
        public static final String SCHEMA_TESTE = "PUBLIC";
    }

    /**
     * CONSTANTS REFERENTES A PARTE DE PERSISTENCIA DO PROJETO.
     *
     * @since 1.0.0.1
     */
    public static final class PERSISTENCE {

        private PERSISTENCE() {
            super();
        }

        /**
         * NOME DO PERSISTENCE UNIT DA APLICAÇÃO.
         */
        public static final String NOME_PERSISTENCE_UNIT = "MURALPU";
        
        /**
         * ENDEREÇO DO PERSISTENCE UNIT.
         */
        public static final String PERSISTENCE_XML_LOCATOR = "classpath:META-INF/persistence.xml";
    }
}
