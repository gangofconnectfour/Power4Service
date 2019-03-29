alter table if exists public.multi_game
  drop constraint if exists FKecqqxoytsl7aowggu534l715;

alter table if exists public.multi_game
  drop constraint if exists FKm0orpvsuqao6s2m2me3kqyx2g;

alter table if exists public.solo_game
  drop constraint if exists FKlek61sopngxm70vcxpia1mh3x;

alter table if exists public.solo_game
  drop constraint if exists FK6m60nygh8ht1sjhhr35uqy7fm;

alter table if exists public.user
  drop constraint if exists FKqt07fq5h7woibnw0rarxlpv66;

alter table if exists public.user_auths
  drop constraint if exists FKsxpx26a2qb9ubjddgru1fq725;

alter table if exists public.user_auths
  drop constraint if exists FKhiox4t8qk8l9npbp4ktejcdym;

alter table if exists public.user_multi_games
  drop constraint if exists FKp9rq1qk8un93tx5sai5o3m8pb;

alter table if exists public.user_multi_games
  drop constraint if exists FKl0lpdpve0g6r0fun5lpfy4job;

alter table if exists public.user_solo_games
  drop constraint if exists FKqvnwx3omeiteusfl3s2ja9quo;

alter table if exists public.user_solo_games
  drop constraint if exists FKgmch3i36unsuo0lxu8mbx32g3;

drop table if exists public.auth cascade;

drop table if exists public.game cascade;

drop table if exists public.multi_game cascade;

drop table if exists public.profile cascade;

drop table if exists public.score_logger cascade;

drop table if exists public.solo_game cascade;

drop table if exists public.user cascade;

drop table if exists public.user_auths cascade;

drop table if exists public.user_multi_games cascade;

drop table if exists public.user_solo_games cascade;