package com.game.zombilewars.objetos;

import com.badlogic.gdx.physics.box2d.Body;
import com.game.zombilewars.Assets;


public class HeroLumber extends Personajes {

	public HeroLumber(Body body) {
		super(body);
		DURATION_ATTACK = Assets.heroLumberShoot.animationDuration;
		DURATION_DEAD = Assets.heroForceDie.animationDuration + .2f;
		VELOCIDAD_WALK = 1;
		DAMAGE = 1;
		DISTANCE_ATTACK = .5f;
		TIME_TO_ATTACK_AGAIN = 0;
		vidas = 5;
		isFacingLeft = false;
		tipo = TIPO_NO_RANGO;
	}

}
