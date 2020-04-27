#version 110

uniform sampler2D DiffuseSampler;

varying vec2 texCoord;

uniform float LeftBound;
uniform float RightBound;

void main() {
	vec2 TrueCoord = texCoord;
	if(TrueCoord.x >= LeftBound && TrueCoord.x <= RightBound)
		TrueCoord = vec2(1.0 - TrueCoord.x, TrueCoord.y);

    vec4 InTexel = texture2D(DiffuseSampler, TrueCoord);

    gl_FragColor = InTexel;
}
