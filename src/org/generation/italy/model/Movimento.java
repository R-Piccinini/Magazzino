package org.generation.italy.model;

import java.time.LocalDate;

public class Movimento {
		public LocalDate data;
        public int codProdotto,qntProdotto,chiave;
        public String riferimento;
		public int codCliente;
		public int codFornitore;
		public int codMovimento;
		@Override
		public String toString() {
			return "Movimento [data=" + data + ", codProdotto=" + codProdotto + ", qntProdotto=" + qntProdotto
					+ ", chiave=" + chiave + ", riferimento=" + riferimento + ", codCliente=" + codCliente
					+ ", codFornitore=" + codFornitore + ", codMovimento=" + codMovimento + "]";
		}
		
        
}